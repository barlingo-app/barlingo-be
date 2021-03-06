package com.barlingo.backend.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.groups.Default;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
import com.barlingo.backend.models.validations.EditionValidation;
import com.barlingo.backend.models.validations.RegisterValidation;
import com.barlingo.backend.utilities.ResponseBody;
import com.barlingo.backend.utilities.RestError;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/establishments")
public class EstablishmentRestController extends AbstractRestController {

  @Autowired
  private IEstablishmentService establishmentService;
  @Autowired
  private EstablishmentMapper establishmentMapper;
  @Autowired
  private IUploadFileService uploadService;

  @GetMapping("")
  public ResponseEntity<ResponseBody> findAllEstablishments(
      @RequestParam(value = "subAct", required = false, defaultValue = "true") Boolean subAct) {
    ResponseEntity<ResponseBody> result;
    Collection<EstablishmentGenericDTO> establishments;

    try {
      if (subAct)
        establishments = this.establishmentMapper
            .establishmentsToDtos(this.establishmentService.findByDateGreater(LocalDateTime.now()));
      else
        establishments =
            this.establishmentMapper.establishmentsToDtos(this.establishmentService.findAll());
      result = this.createResponse(establishments);
    } catch (Exception e) {
      result = this.createMessageException(e);
    }

    return result;
  }

  @GetMapping("/{estId}")
  public ResponseEntity<ResponseBody> show(@PathVariable int estId) {
    ResponseEntity<ResponseBody> result;
    try {
      EstablishmentDetailsDTO establisment =
          this.establishmentMapper.establishmentToDto(this.establishmentService.findById(estId));
      result = this.createResponse(establisment);
    } catch (Exception e) {
      result = this.createMessageException(e);
    }

    return result;
  }

  @PostMapping("")
  public ResponseEntity<ResponseBody> register(@Validated({RegisterValidation.class}) @RequestBody(
      required = false) EstablishmentDetailsDTO estData, BindingResult binding) {
    ResponseEntity<ResponseBody> result;

    if (binding.hasErrors()) {
      result = this.createResponse(estData, binding);
    } else {
      try {
        // Check if exist username
        if (this.establishmentService.findByUsername(estData.getUsername()) != null) {
          Assert.isTrue(false, RestError.ALL_ESTABLISHMENT_USERNAME_EXISTS);
        }
        EstablishmentDetailsDTO establishment = this.establishmentMapper
            .establishmentToDto(this.establishmentService.register(estData));
        result = this.createResponse(establishment);
      } catch (Exception e) {
        result = this.createMessageException(e);
      }
    }
    return result;
  }

  @PutMapping("/{id}")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ESTABLISHMENT')")
  public ResponseEntity<ResponseBody> edit(
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal,
      @Validated({EditionValidation.class,
          Default.class}) @RequestBody EstablishmentDetailsDTO establishmentData,
      BindingResult binding) {
    ResponseEntity<ResponseBody> result;

    if (binding.hasErrors()) {
      result = this.createResponse(establishmentData, binding);
    } else {
      try {
        EstablishmentDetailsDTO establishment = this.establishmentMapper
            .establishmentToDto(this.establishmentService.edit(principal, establishmentData));
        result = this.createResponse(establishment);
      } catch (Exception e) {
        result = this.createMessageException(e);
      }
    }
    return result;
  }

  @PostMapping("/{id}/upload")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ESTABLISHMENT')")
  public ResponseEntity<ResponseBody> uploadFile(HttpServletRequest request,
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal,
      @PathVariable Integer id,
      @RequestParam(name = "imageType", required = false,
          defaultValue = "profile") String imageType,
      @RequestBody(required = true) MultipartFile file) {
    ResponseEntity<ResponseBody> result;

    try {
      Establishment est = this.establishmentService.findByUsername(principal.getUsername());
      String image = this.uploadService.copy(file);
      if (imageType.equals("background")) {
        est.setImages(Arrays.asList(request.getRequestURL().toString().split("establishments")[0]
            + "static/images/" + image));
      } else if (imageType.equals("profile")) {
        est.setImageProfile(request.getRequestURL().toString().split("establishments")[0]
            + "static/images/" + image);
      }
      EstablishmentDetailsDTO establishment =
          this.establishmentMapper.establishmentToDto(this.establishmentService.edit(principal,
              this.establishmentMapper.establishmentToDto(est)));
      result = this.createResponse(establishment);
    } catch (Exception e) {
      result = this.createMessageException(e);
    }
    return result;
  }

  @GetMapping(value = "/uploads/{filename:.+}")
  public ResponseEntity<Resource> seePhoto(@PathVariable String filename,
      HttpServletRequest request) {
    ResponseEntity<Resource> result = null;
    Resource resource = this.uploadService.load(filename);

    String contentType = null;
    try {
      contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
      result = ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
          .header(HttpHeaders.CONTENT_DISPOSITION,
              "attachment; filename=\"" + resource.getFilename() + "\"")
          .body(resource);
    } catch (IOException ex) {
      log.info(RestError.ESTABLISHMENT_ESTABLISHMENT_UNKNOWN_FILETYPE);
    }

    return result;
  }

  @PostMapping("/{id}/anonymize")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ESTABLISHMENT')")
  public ResponseEntity<ResponseBody> anonymize(
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal,
      @PathVariable Integer id) {
    ResponseEntity<ResponseBody> result;

    try {
      EstablishmentDetailsDTO establishment =
          this.establishmentMapper.establishmentToDto(this.establishmentService.anonymize(id));
      result = this.createResponse(establishment);
    } catch (Exception e) {
      result = this.createMessageException(e);
    }
    return result;
  }


  @GetMapping("/{id}/download")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ESTABLISHMENT')")
  public void download(
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal,
      @PathVariable Integer id, HttpServletResponse response) {

    InputStream targetStream = null;
    try {

      ObjectMapper objectMapper = new ObjectMapper();
      String jsonUserDetailsDTO = objectMapper.writerWithDefaultPrettyPrinter()
          .writeValueAsString(this.establishmentService.exportData(principal, id));

      targetStream = new ByteArrayInputStream(jsonUserDetailsDTO.getBytes());

      // Set the content type and attachment header.
      response.addHeader("Content-disposition", "attachment;filename=myfilename.txt");
      response.setContentType("txt/plain");

      IOUtils.copy(targetStream, response.getOutputStream());
      response.flushBuffer();

    } catch (Exception e) {
      if (e.getMessage()
          .equals(RestError.ESTABLISHMENT_ESTABLISHMENT_CANNOT_ACCESS_OTHER_USERS_DATA)) {
        InputStream errorStream = new ByteArrayInputStream("Operation Not Authorized".getBytes());
        // Set the content type and attachment header.
        response.addHeader("Content-disposition", "attachment;filename=notAuthorized.txt");
        response.setContentType("txt/plain");
        try {
          IOUtils.copy(errorStream, response.getOutputStream());
          response.flushBuffer();
        } catch (IOException ex) {
          log.error(ex.getMessage());
        } finally {
          try {
            if (errorStream != null)
              errorStream.close();
          } catch (IOException ex) {
            log.error(ex.getMessage());
          }
        }
      }
    } finally {
      try {
        if (targetStream != null)
          targetStream.close();
      } catch (IOException e) {
        log.error(e.getMessage());
      }
    }

  }

}
