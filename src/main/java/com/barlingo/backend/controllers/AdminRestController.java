package com.barlingo.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.barlingo.backend.models.dtos.AdminDetailsDTO;
import com.barlingo.backend.models.mapper.AdminMapper;
import com.barlingo.backend.models.services.IAdminService;

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
