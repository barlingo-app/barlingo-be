package com.barlingo.backend.models.services;


import java.time.LocalDateTime;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.barlingo.backend.models.dtos.AssessmentCreateDTO;
import com.barlingo.backend.models.entities.Assessment;
import com.barlingo.backend.models.entities.LanguageExchange;
import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.repositories.AssessmentRepository;
import com.barlingo.backend.utilities.RestError;
import io.jsonwebtoken.lang.Assert;

@Service
@Transactional
public class AssessmentServiceImpl implements IAssessmentService {


  @Autowired
  private AssessmentRepository assessmentRepository;
  @Autowired
  private ILanguageExchangeService languageExchangeService;
  @Autowired
  private IUserService userService;

  @Override
  public Assessment findById(Integer id) {
    Assessment assessment = this.assessmentRepository.findById(id).orElse(null);
    Assert.notNull(assessment, "Assessment id not exists.");
    return assessment;
  }

  @Override
  public Collection<Assessment> findByUserId(Integer userId) {
    return this.assessmentRepository.findByAssessedUserId(userId);
  }

  @Override
  public Assessment createAndSave(org.springframework.security.core.userdetails.User principal,
      Integer exchangeId, AssessmentCreateDTO assessmentData) {
    User user = this.userService.findByUsername(principal.getUsername());
    Assert.notNull(user, RestError.USER_USER_NOT_FOUND);
    User assessedUser = this.userService.findById(assessmentData.getAssessedUserId());
    Assert.notNull(assessedUser, RestError.USER_USER_NOT_FOUND);

    LanguageExchange exchange = this.languageExchangeService.findById(exchangeId);
    Assert.notNull(exchange, RestError.SIGNED_LANGUAGE_EXCHANGE_NOT_FOUND);

    // Check if date exchange is past
    Assert.isTrue(LocalDateTime.now().isAfter(exchange.getMoment()),
        RestError.SIGNED_ASSESSMENT_EXCHANGE_MOMENT_NOT_PAST);
    // Check if user and assessedUser match in same exchange any time
    Assert.isTrue(user.getLangsExchanges().contains(exchange),
        RestError.SIGNED_ASSESSMENT_USER_OR_ASSESSEDUSER_NOT_MATCH_IN_SAME_EXCHANGE);
    Assert.isTrue(assessedUser.getLangsExchanges().contains(exchange),
        RestError.SIGNED_ASSESSMENT_USER_OR_ASSESSEDUSER_NOT_MATCH_IN_SAME_EXCHANGE);
    // Check user not assessment himself
    Assert.isTrue(!assessedUser.equals(user),
        RestError.SIGNED_ASSESSMENT_USER_AND_ASSESSEDUSER_MUST_NOT_BE_SAME);

    // Check if assesment exists
    Assessment assessment =
        this.assessmentRepository.findByUserIdAndAssessedUserId(user.getId(), assessedUser.getId());
    if (assessment == null) {
      assessment = new Assessment();
      assessment.setUser(user);
      assessment.setAlike(assessmentData.getAlike());
      assessment.setAssessedUser(assessedUser);
    } else {
      assessment.setAlike(assessmentData.getAlike());
    }

    return this.assessmentRepository.save(assessment);
  }

}
