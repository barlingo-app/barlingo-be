package com.barlingo.backend.models.services;

import java.util.Collection;
import com.barlingo.backend.models.entities.Assessment;

public interface IAssessmentService {

  Assessment findById(Integer id);

  Collection<Assessment> findByUserId(Integer userId);

}
