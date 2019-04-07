package com.barlingo.backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.barlingo.backend.models.dtos.UserDetailsDTO;
import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.forms.UserEdit;
import com.barlingo.backend.models.forms.UserSignin;
import com.barlingo.backend.models.mapper.UserMapper;
import com.barlingo.backend.models.services.IUserService;
import com.barlingo.backend.utilities.ResponseBody;
import com.barlingo.backend.utilities.Utils;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/users")

public class UserRestController {

  @Autowired
  private IUserService userService;

  @Autowired
  private UserMapper userMapper;

  @GetMapping("")
  public List<UserDetailsDTO> findUser() {
    List<User> userList = userService.findAll();
    return this.userMapper.entitysToDtos(userList);
  }

  @GetMapping("/{id}")
  public UserDetailsDTO show(@PathVariable Integer id) {
    return this.userMapper.entityToDto(this.userService.findById(id));
  }

  @GetMapping("/username/{username}")
  public UserDetailsDTO findByUsername(@PathVariable String username) {
    return this.userMapper.entityToDto(this.userService.findByUsername(username));
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
      responseBody.setSuccess(this.userService.findByUsername(username) == null);
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

  @PostMapping("/register")
  public ResponseEntity<ResponseBody> register(@RequestBody(required = false) UserSignin userData,
      BindingResult binding) {
    ResponseBody responseBody = new ResponseBody();

    try {
      responseBody.setSuccess(false);
      responseBody.setCode(400);

      if (this.userService.findByUsername(userData.getUsername()) != null) {
        responseBody.setMessage("The username already exists.");
      } else {
        responseBody.setCode(200);
        responseBody.setSuccess(true);
        responseBody
            .setContent(this.userMapper.entityToDto(this.userService.register(userData, binding)));
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

  @PostMapping("/edit")
  public ResponseEntity<ResponseBody> edit(@RequestBody(required = false) UserEdit userData,
      BindingResult binding) {
    ResponseBody responseBody = new ResponseBody();

    try {
      responseBody.setCode(200);
      responseBody.setSuccess(true);
      responseBody
          .setContent(this.userMapper.entityToDto(this.userService.edit(userData, binding)));
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
