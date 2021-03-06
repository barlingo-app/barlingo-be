package com.barlingo.backend.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.barlingo.backend.models.dtos.UserDetailsDTO;
import com.barlingo.backend.models.dtos.UserEditDTO;
import com.barlingo.backend.models.dtos.UserSigninDTO;
import com.barlingo.backend.models.entities.Assessment;
import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.mapper.AssessmentMapper;
import com.barlingo.backend.models.mapper.UserMapper;
import com.barlingo.backend.models.services.IAssessmentService;
import com.barlingo.backend.models.services.IUploadFileService;
import com.barlingo.backend.models.services.IUserService;
import com.barlingo.backend.security.UserAccountSecurityService;
import com.barlingo.backend.utilities.ResponseBody;
import com.barlingo.backend.utilities.RestError;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserRestController extends AbstractRestController {

  @Autowired
  private IUserService userService;
  @Autowired
  private UserAccountSecurityService userAccountService;
  @Autowired
  private IUploadFileService uploadService;
  @Autowired
  private UserMapper userMapper;
  @Autowired
  private IAssessmentService assessmentService;
  @Autowired
  private AssessmentMapper assessmentMapper;

  @GetMapping
  public ResponseEntity<ResponseBody> findUser() {
    ResponseEntity<ResponseBody> result;
    try {
      List<UserDetailsDTO> users = this.userMapper.entitysToDetailsDtos(userService.findAll());
      for (UserDetailsDTO userDet : users) {
        Collection<Assessment> assessments = this.assessmentService.findByUserId(userDet.getId());
        userDet.setAssessments(this.assessmentMapper.entitysToDtos(assessments));
      }
      result = this.createResponse(users);
    } catch (Exception e) {
      result = this.createMessageException(e);
    }
    return result;
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponseBody> show(@PathVariable Integer id) {
    ResponseEntity<ResponseBody> result;
    try {
      UserDetailsDTO user = this.userMapper.entityToDetailsDto(this.userService.findById(id));

      Collection<Assessment> assessments = this.assessmentService.findByUserId(user.getId());
      user.setAssessments(this.assessmentMapper.entitysToDtos(assessments));

      result = this.createResponse(user);
    } catch (Exception e) {
      result = this.createMessageException(e);
    }
    return result;
  }

  @GetMapping("/username/{username}")
  public ResponseEntity<ResponseBody> findByUsername(@PathVariable String username) {
    ResponseEntity<ResponseBody> result;
    try {
      UserDetailsDTO user =
          this.userMapper.entityToDetailsDto(this.userService.findByUsername(username));

      Collection<Assessment> assessments = this.assessmentService.findByUserId(user.getId());
      user.setAssessments(this.assessmentMapper.entitysToDtos(assessments));

      result = this.createResponse(user);
    } catch (Exception e) {
      result = this.createMessageException(e);
    }
    return result;
  }

  @PostMapping("/signin")
  public ResponseEntity<ResponseBody> login(//
      @RequestParam String username, //
      @RequestParam String password) {
    ResponseEntity<ResponseBody> result;
    try {
      result = this.createResponse(this.userService.login(username, password));
    } catch (Exception e) {
      result = this.createMessageException(e);
    }
    return result;
  }

  @GetMapping("/checkUsername")
  public ResponseEntity<ResponseBody> checkUsername(
      @RequestParam(required = false) String username) {
    ResponseEntity<ResponseBody> result;
    try {
      Boolean usernameExist = this.userAccountService.usernameExists(username);
      if (usernameExist) {
        Assert.isTrue(false, RestError.ALL_USER_USERNAME_EXISTS);
      }
      result = this.createResponse("username.available");
    } catch (Exception e) {
      result = this.createMessageException(e);
    }

    return result;
  }

  @PostMapping(value = "/register")
  public ResponseEntity<ResponseBody> register(
      @Valid @RequestBody(required = false) UserSigninDTO userData, BindingResult binding) {
    ResponseEntity<ResponseBody> result;

    if (binding.hasErrors()) {
      result = this.createResponse(userData, binding);
    } else {
      try {
        // Check if exist username
        if (this.userService.findByUsername(userData.getUsername()) != null) {
          Assert.isTrue(false, RestError.ALL_USER_USERNAME_EXISTS);
        }
        UserSigninDTO user = this.userMapper.entityToSigninDTO(this.userService.register(userData));
        result = this.createResponse(user);
      } catch (Exception e) {
        result = this.createMessageException(e);
      }
    }
    return result;
  }

  @PostMapping("/{id}/upload")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
  public ResponseEntity<ResponseBody> uploadFile(HttpServletRequest request,
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal,
      @PathVariable Integer id,
      @RequestParam(name = "imageType", required = false) String imageType,
      @RequestBody(required = true) MultipartFile file) {
    ResponseEntity<ResponseBody> result;

    try {
      User user = this.userService.findByUsername(principal.getUsername());
      String image = this.uploadService.copy(file);
      if (imageType != null && imageType.equals("personal")) {
        user.setPersonalPic(
            request.getRequestURL().toString().split("users")[0] + "static/images/" + image);
      } else {
        user.setProfileBackPic(
            request.getRequestURL().toString().split("users")[0] + "static/images/" + image);
      }
      result = this.createResponse(this.userMapper.entityToDetailsDto(
          this.userService.edit(principal, this.userMapper.entityToEditDTO(user))));
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
      log.info(RestError.USER_USER_UNKNOWN_FILETYPE);
    }

    return result;
  }

  @PostMapping("/edit")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
  public ResponseEntity<ResponseBody> edit(
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal,
      @RequestBody @Valid UserEditDTO userData, BindingResult binding) {
    ResponseEntity<ResponseBody> result;

    if (binding.hasErrors()) {
      result = this.createResponse(userData, binding);
    } else {
      try {
        result = this.createResponse(
            this.userMapper.entityToDetailsDto(this.userService.edit(principal, userData)));
      } catch (Exception e) {
        result = this.createMessageException(e);
      }
    }
    return result;
  }

  @PostMapping("/{id}/ban")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  public ResponseEntity<ResponseBody> activateDeactivate(@PathVariable Integer id) {
    ResponseEntity<ResponseBody> result;
    try {
      result = this.createResponse(
          this.userMapper.entityToDetailsDto(this.userService.activateDeactivateUser(id)));
    } catch (Exception e) {
      result = this.createMessageException(e);
    }
    return result;
  }

  @PostMapping("/{id}/anonymize")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
  public ResponseEntity<ResponseBody> anonymize(
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal,
      @PathVariable Integer id) {
    ResponseEntity<ResponseBody> result;
    try {
      result =
          this.createResponse(this.userMapper.entityToDetailsDto(this.userService.anonymize(id)));
    } catch (Exception e) {
      result = this.createMessageException(e);
    }
    return result;
  }

  @GetMapping("/{id}/download")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
  public void download(
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal,
      @PathVariable Integer id, HttpServletResponse response) {

    InputStream targetStream = null;
    try {

      ObjectMapper objectMapper = new ObjectMapper();
      String jsonUserDetailsDTO = objectMapper.writerWithDefaultPrettyPrinter()
          .writeValueAsString(this.userService.exportData(principal, id));

      targetStream = new ByteArrayInputStream(jsonUserDetailsDTO.getBytes());

      // Set the content type and attachment header.
      response.addHeader("Content-disposition", "attachment;filename=myfilename.txt");
      response.setContentType("txt/plain");

      IOUtils.copy(targetStream, response.getOutputStream());
      response.flushBuffer();

    } catch (Exception e) {
      if (e.getMessage().equals(RestError.USER_USER_CANNOT_ACCESS_OTHER_USERS_DATA)) {
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
