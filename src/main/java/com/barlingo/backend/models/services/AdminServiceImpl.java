package com.barlingo.backend.models.services;


import com.barlingo.backend.models.entities.Admin;
import com.barlingo.backend.models.repositories.ActorRepository;
import com.barlingo.backend.models.repositories.AdminRepository;
import com.barlingo.backend.security.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {


  @Autowired
  private AdminRepository adminRepository;


  @Override
  public Admin findById(Integer id) {
    return this.adminRepository.findById(id).orElse(null);
  }

}
