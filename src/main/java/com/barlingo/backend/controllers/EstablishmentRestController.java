package com.barlingo.backend.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
import org.springframework.web.multipart.MultipartFile;
import com.barlingo.backend.models.dtos.EstablishmentDetailsDTO;
import com.barlingo.backend.models.dtos.EstablishmentGenericDTO;
import com.barlingo.backend.models.entities.Establishment;
import com.barlingo.backend.models.mapper.EstablishmentMapper;
import com.barlingo.backend.models.services.IEstablishmentService;
import com.barlingo.backend.models.services.IUploadFileService;
import com.barlingo.backend.models.validations.RegisterValidation;
import com.barlingo.backend.utilities.ResponseBody;
import com.barlingo.backend.utilities.Utils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/establishments")
public class EstablishmentRestController {

  @Autowired
  private IEstablishmentService establishmentService;
  @Autowired
  private EstablishmentMapper establishmentMapper;
  @Autowired
  private IUploadFileService uploadService;

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

  @PutMapping("/{id}")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ESTABLISHMENT')")
  public ResponseEntity<ResponseBody> edit(
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal,
      @RequestBody @Valid EstablishmentDetailsDTO establishmentData, BindingResult binding) {
    ResponseBody responseBody = new ResponseBody();

    if (binding.hasErrors()) {
      responseBody.setCode(400);
      responseBody.setSuccess(false);
      responseBody.setValidationErrors(Utils.convertValidationErrors(binding));
    } else {
      responseBody.setCode(200);
      responseBody.setSuccess(true);
      responseBody.setContent(this.establishmentMapper
          .establishmentToDto(this.establishmentService.edit(principal, establishmentData)));
    }

    return ResponseEntity.ok().body(responseBody);
  }

  @PostMapping("/{id}/upload")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ESTABLISHMENT')")
  public ResponseEntity<ResponseBody> uploadFile(
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal,
      @PathVariable Integer id,
      @RequestParam(name = "imageType", required = false) String imageType,
      @RequestBody(required = true) MultipartFile file) {
    ResponseBody responseBody = new ResponseBody();

    Establishment establishment = this.establishmentService.findById(id);
    String image = "";
    try {
      image = this.uploadService.copy(file);
    } catch (IOException e) {
      log.error(e.getMessage());
    }

    establishment.setImageProfile(image);

    responseBody.setCode(200);
    responseBody.setSuccess(true);
    responseBody.setContent(this.establishmentMapper.establishmentToDto(this.establishmentService
        .edit(principal, this.establishmentMapper.establishmentToDto(establishment))));

    return ResponseEntity.ok().body(responseBody);
  }

  @GetMapping(value = "/uploads/{filename:.+}")
  public ResponseEntity<Resource> seePhoto(@PathVariable String filename,
      HttpServletRequest request) {

    Resource resource = null;

    try {
      resource = this.uploadService.load(filename);
    } catch (MalformedURLException e) {
      log.error(e.getMessage());
    }

    String contentType = null;
    try {
      contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
    } catch (IOException ex) {
      log.info("Could not determine file type.");
    }

    return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
        .header(HttpHeaders.CONTENT_DISPOSITION,
            "attachment; filename=\"" + resource.getFilename() + "\"")
        .body(resource);
  }


}
