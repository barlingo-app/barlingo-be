package com.barlingo.backend.models.services;

import java.util.Collection;
import com.barlingo.backend.models.dtos.AssessmentCreateDTO;
import com.barlingo.backend.models.entities.Assessment;

public interface IAssessmentService {

  Assessment findById(Integer id);

  Collection<Assessment> findByUserId(Integer userId);

  Assessment createAndSave(org.springframework.security.core.userdetails.User principal,
      Integer exchangeId, AssessmentCreateDTO assessmentData);

}
