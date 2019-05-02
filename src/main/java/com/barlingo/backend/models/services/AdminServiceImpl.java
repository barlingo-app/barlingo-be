package com.barlingo.backend.models.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.barlingo.backend.models.entities.Admin;
import com.barlingo.backend.models.repositories.AdminRepository;
import io.jsonwebtoken.lang.Assert;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {


  @Autowired
  private AdminRepository adminRepository;


  @Override
  public Admin findById(Integer id) {
    Admin admin = this.adminRepository.findById(id).orElse(null);
    Assert.notNull(admin, "Administrator id not exists.");
    return admin;
  }

}
