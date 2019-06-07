package com.barlingo.backend.controllers;

import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.barlingo.backend.models.dtos.AssessmentCreateDTO;
import com.barlingo.backend.models.dtos.AssessmentDTO;
import com.barlingo.backend.models.mapper.AssessmentMapper;
import com.barlingo.backend.models.services.IAssessmentService;
import com.barlingo.backend.utilities.ResponseBody;

@RestController
@RequestMapping("/assessments")
public class AssessmentRestController extends AbstractRestController {

  @Autowired
  private IAssessmentService assessmentService;
  @Autowired
  private AssessmentMapper assessmentMapper;


  @GetMapping("/{userId}")
  @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
  public ResponseEntity<ResponseBody> show(@PathVariable Integer userId) {
    ResponseEntity<ResponseBody> result;
    try {
      Collection<AssessmentDTO> assessment =
          this.assessmentMapper.entitysToDtos(this.assessmentService.findByUserId(userId));
      result = this.createResponse(assessment);
    } catch (Exception e) {
      result = this.createMessageException(e);
    }
    return result;
  }

  @PostMapping("/{exchangeId}")
  @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
  public ResponseEntity<ResponseBody> save(
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal,
      @Valid @RequestBody(required = false) AssessmentCreateDTO assessmentData,
      @PathVariable Integer exchangeId, BindingResult binding) {
    ResponseEntity<ResponseBody> result;

    if (binding.hasErrors()) {
      result = this.createResponse(assessmentData, binding);
    } else {
      try {
        AssessmentDTO assessment = this.assessmentMapper.entityToDto(
            this.assessmentService.createAndSave(principal, exchangeId, assessmentData));
        result = this.createResponse(assessment);
      } catch (Exception e) {
        result = this.createMessageException(e);
      }
    }

    return result;
  }

}
