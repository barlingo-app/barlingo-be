package com.barlingo.backend.models.mapper;

import java.util.Collection;
import org.mapstruct.Mapper;
import com.barlingo.backend.models.dtos.AssessmentDTO;
import com.barlingo.backend.models.entities.Assessment;

@Mapper(componentModel = "spring")
public interface AssessmentMapper {

  AssessmentDTO entityToDto(Assessment assessment);

  Collection<AssessmentDTO> entitysToDtos(Collection<Assessment> assessments);

  Assessment dtoToEntity(AssessmentDTO assessment);

}
