package com.barlingo.backend.controllers;

import com.barlingo.backend.models.dtos.AdminDetailsDTO;
import com.barlingo.backend.models.dtos.UserDetailsDTO;
import com.barlingo.backend.models.entities.User;
import com.barlingo.backend.models.forms.UserEdit;
import com.barlingo.backend.models.forms.UserSignin;
import com.barlingo.backend.models.mapper.AdminMapper;
import com.barlingo.backend.models.mapper.UserAccountMapper;
import com.barlingo.backend.models.mapper.UserMapper;
import com.barlingo.backend.models.services.IAdminService;
import com.barlingo.backend.models.services.IUserService;
import com.barlingo.backend.utilities.ResponseBody;
import com.barlingo.backend.utilities.Utils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/admins")
public class AdminRestController {

  @Autowired
  private IAdminService adminService;
  @Autowired
  private AdminMapper adminMapper;


  @GetMapping("/{id}")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  public AdminDetailsDTO show(@PathVariable Integer id) {
    return this.adminMapper.entityToDto(this.adminService.findById(id));
  }

}
