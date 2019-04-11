package com.barlingo.backend.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
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
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.mapper.UserAccountMapper;
import com.barlingo.backend.models.mapper.UserMapper;
import com.barlingo.backend.models.services.IUploadFileService;
import com.barlingo.backend.models.services.IUserService;
import com.barlingo.backend.security.UserAccountSecurityService;
import com.barlingo.backend.utilities.ResponseBody;
import com.barlingo.backend.utilities.Utils;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/users")
@Slf4j
public class UserRestController {

  @Autowired
  private IUserService userService;
  @Autowired
  private UserAccountSecurityService userAccountService;
  @Autowired
  private IUploadFileService uploadService;
  @Autowired
  private UserMapper userMapper;
  @Autowired
  UserAccountMapper userAccountMapper;

  @GetMapping("")
  public List<UserDetailsDTO> findUser() {
    List<User> userList = userService.findAll();
    return this.userMapper.entitysToDetailsDtos(userList);
  }

  @GetMapping("/{id}")
  public UserDetailsDTO show(@PathVariable Integer id) {
    return this.userMapper.entityToDetailsDto(this.userService.findById(id));
  }

  @GetMapping("/username/{username}")
  public UserDetailsDTO findByUsername(@PathVariable String username) {
    return this.userMapper.entityToDetailsDto(this.userService.findByUsername(username));
  }

  @PostMapping("/signin")
  public String login(//
      @RequestParam String username, //
      @RequestParam String password) {
    return userService.login(username, password);
  }

  @GetMapping("/checkUsername")
  public ResponseEntity<ResponseBody> checkUsername(
      @RequestParam(required = false) String username) {
    ResponseBody responseBody = new ResponseBody();
    try {
      Assert.notNull(username, "The username must be not empty.");
      responseBody.setCode(200);
      responseBody.setSuccess(!this.userAccountService.usernameExists(username));
      if (!responseBody.getSuccess()) {
        responseBody.setMessage("The username already exists.");
      }
    } catch (Exception e) {
      responseBody.setSuccess(false);
      responseBody.setCode(400);
      responseBody.setMessage(e.getMessage());
    }

    return ResponseEntity.ok().body(responseBody);
  }

  @PostMapping(value = "/register")
  public ResponseEntity<ResponseBody> register(
      @RequestBody(required = false) UserSigninDTO userData, BindingResult binding) {
    ResponseBody responseBody = new ResponseBody();

    try {
      responseBody.setSuccess(false);
      responseBody.setCode(400);

      if (this.userService.findByUsername(userData.getUsername()) != null) {
        responseBody.setMessage("The username already exists.");
      } else {
        responseBody.setCode(200);
        responseBody.setSuccess(true);
        responseBody.setContent(
            this.userMapper.entityToDetailsDto(this.userService.register(userData, binding)));
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

  @PostMapping("/{id}/upload")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
  public ResponseEntity<ResponseBody> uploadFile(
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal,
      @PathVariable Integer id, @RequestParam(name = "imageType") String imageType,
      @RequestBody(required = true) MultipartFile file) {
    ResponseBody responseBody = new ResponseBody();

    User user = this.userService.findById(id);
    String image = "";
    try {
      image = this.uploadService.copy(file);
    } catch (IOException e) {
      log.error(e.getMessage());
    }
    if (imageType.equals("personal")) {
      user.setPersonalPic(image);
    } else {
      user.setProfileBackPic(image);
    }
    responseBody.setCode(200);
    responseBody.setSuccess(true);
    responseBody.setContent(this.userMapper.entityToDetailsDto(
        this.userService.edit(principal, this.userMapper.entityToEditDTO(user))));

    return ResponseEntity.ok().body(responseBody);
  }

  @GetMapping(value = "/uploads/{filename:.+}")
  public ResponseEntity<Resource> verFoto(@PathVariable String filename,
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

  @PostMapping("/edit")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
  public ResponseEntity<ResponseBody> edit(
      @AuthenticationPrincipal org.springframework.security.core.userdetails.User principal,
      @RequestBody @Valid UserEditDTO userData, BindingResult binding) {
    ResponseBody responseBody = new ResponseBody();

    if (binding.hasErrors()) {
      responseBody.setCode(400);
      responseBody.setSuccess(false);
      responseBody.setValidationErrors(Utils.convertValidationErrors(binding));
    } else {
      responseBody.setCode(200);
      responseBody.setSuccess(true);
      responseBody.setContent(
          this.userMapper.entityToDetailsDto(this.userService.edit(principal, userData)));
    }

    return ResponseEntity.ok().body(responseBody);
  }

  @PostMapping("/{id}/ban")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  public ResponseEntity<ResponseBody> activateDeactivate(@PathVariable Integer id) {
    ResponseBody responseBody = new ResponseBody();

    responseBody.setCode(200);
    responseBody.setSuccess(true);
    responseBody.setContent(
        this.userMapper.entityToDetailsDto(this.userService.activateDeactivateUser(id)));

    return ResponseEntity.ok().body(responseBody);
  }

  // @PostMapping("/uploadFile")
  // public ResponseEntity<ResponseBody> uploadFile(@RequestParam("file") MultipartFile file) {
  // ResponseBody responseBody = new ResponseBody();
  //
  // responseBody.setCode(200);
  // responseBody.setSuccess(true);
  // responseBody.setContent(this.userMapper.entityToDto(this.userService.addImage(id, file)));
  //
  // return ResponseEntity.ok().body(responseBody);
  // }

  /*
   * @PostMapping("/users")
   * 
   * @ResponseStatus(HttpStatus.CREATED) public User create(@RequestBody User user) {
   * this.userService.save(user); return user; }
   * 
   * @PutMapping("/users/{id}")
   * 
   * @ResponseStatus(HttpStatus.CREATED) public User update(@RequestBody User user, @PathVariable
   * Integer id) { User currentCliente = this.userService.findById(id);
   * currentCliente.setSurname(user.getName()); currentCliente.setSurname(user.getSurname());
   * currentCliente.setEmail(user.getEmail()); this.userService.save(currentCliente); return
   * currentCliente; }
   * 
   * @DeleteMapping("/users/{id}")
   * 
   * @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Integer id) { User
   * currentUser = this.userService.findById(id); this.userService.delete(currentUser); }
   */

}
