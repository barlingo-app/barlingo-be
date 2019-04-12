package com.barlingo.backend.controllers;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.barlingo.backend.models.dtos.EstablishmentDetailsDTO;
import com.barlingo.backend.models.dtos.EstablishmentGenericDTO;
import com.barlingo.backend.models.entities.Establishment;
import com.barlingo.backend.models.mapper.EstablishmentMapper;
import com.barlingo.backend.models.services.IEstablishmentService;
import com.barlingo.backend.models.validations.RegisterValidation;
import com.barlingo.backend.utilities.ResponseBody;
import com.barlingo.backend.utilities.Utils;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/establishments")
public class EstablishmentRestController {

  @Autowired
  private IEstablishmentService establishmentService;
  @Autowired
  private EstablishmentMapper establishmentMapper;

  @GetMapping("")
  public List<EstablishmentGenericDTO> findAllEstablishments(
      @RequestParam(value = "subAct", required = false, defaultValue = "true") Boolean subAct) {
    List<Establishment> establishments;
    if (subAct)
      establishments = this.establishmentService.findByDateGreater(LocalDateTime.now());
    else
      establishments = (List<Establishment>) this.establishmentService.findAll();

    return this.establishmentMapper.establishmentsToDtos(establishments);
  }

  @GetMapping("/{estId}")
  public EstablishmentDetailsDTO show(@PathVariable int estId) {
    return this.establishmentMapper.establishmentToDto(this.establishmentService.findById(estId));
  }

  @PostMapping("")
  public ResponseEntity<ResponseBody> register(@Validated({RegisterValidation.class}) @RequestBody(
      required = false) EstablishmentDetailsDTO estData, BindingResult binding) {
    ResponseBody responseBody = new ResponseBody();

    try {
      responseBody.setSuccess(false);
      responseBody.setCode(400);

      if (this.establishmentService.findByUsername(estData.getUsername()) != null) {
        responseBody.setMessage("The username already exists.");
      } else {
        responseBody.setCode(200);
        responseBody.setSuccess(true);

        Establishment establish = this.establishmentService.register(estData, binding);

        responseBody.setContent(this.establishmentMapper.establishmentToDto(establish));
      }
    } catch (Exception e) {
      responseBody.setCode(400);
      responseBody.setSuccess(false);
      if (binding.hasErrors()) {
        responseBody.setValidationErrors(Utils.convertValidationErrors(binding));
      } else {
        responseBody.setMessage(e.getMessage());
      }
    }

    return ResponseEntity.ok().body(responseBody);
  }

  /*
   * responseBody.setCode(200); responseBody.setSuccess(true); responseBody
   * .setContent(this.establishmentMapper
   * .establishmentToDto(this.establishmentService.edit(establishmentData, binding)));
   */

  @PutMapping("/{id}")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ESTABLISHMENT')")
  public ResponseEntity<ResponseBody> edit(@PathVariable Integer id,
      @RequestBody(required = false) EstablishmentDetailsDTO establishmentData,
      BindingResult binding) {
    ResponseBody responseBody = new ResponseBody();

    try {
      responseBody.setCode(200);
      responseBody.setSuccess(true);
      responseBody.setContent(this.establishmentMapper
          .establishmentToDto(this.establishmentService.edit(id, establishmentData, binding)));
    } catch (Exception e) {
      responseBody.setCode(400);
      responseBody.setSuccess(false);
      if (binding.hasErrors()) {
        responseBody.setValidationErrors(Utils.convertValidationErrors(binding));
      } else {
        responseBody.setMessage(e.getMessage());
      }
    }

    return ResponseEntity.ok().body(responseBody);
  }

}
