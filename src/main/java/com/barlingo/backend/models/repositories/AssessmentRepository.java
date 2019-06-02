package com.barlingo.backend.models.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import com.barlingo.backend.models.entities.Assessment;

public interface AssessmentRepository extends JpaRepository<Assessment, Integer> {

  Collection<Assessment> findByAssessedUserId(Integer userId);

}
