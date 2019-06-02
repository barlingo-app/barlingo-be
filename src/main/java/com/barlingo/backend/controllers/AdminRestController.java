package com.barlingo.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.barlingo.backend.models.dtos.AdminDetailsDTO;
import com.barlingo.backend.models.mapper.AdminMapper;
import com.barlingo.backend.models.services.IAdminService;
import com.barlingo.backend.utilities.ResponseBody;

@RestController
@RequestMapping("/admins")
public class AdminRestController extends AbstractRestController {

  @Autowired
  private IAdminService adminService;
  @Autowired
  private AdminMapper adminMapper;


  @GetMapping("/{id}")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  public ResponseEntity<ResponseBody> show(@PathVariable Integer id) {
    ResponseEntity<ResponseBody> result;
    try {
      AdminDetailsDTO admin = this.adminMapper.entityToDto(this.adminService.findById(id));
      result = this.createResponse(admin);
    } catch (Exception e) {
      result = this.createMessageException(e);
    }
    return result;
  }

}
