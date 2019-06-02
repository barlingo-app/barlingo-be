package com.barlingo.backend.models.services;


import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.barlingo.backend.models.entities.Assessment;
import com.barlingo.backend.models.repositories.AssessmentRepository;
import io.jsonwebtoken.lang.Assert;

@Service
@Transactional
public class AssessmentServiceImpl implements IAssessmentService {


  @Autowired
  private AssessmentRepository assessmentRepository;


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
}
