package com.barlingo.backend.models.services;

import com.barlingo.backend.models.entities.Establishment;
import com.barlingo.backend.models.repositories.EstablishmentRepository;
import com.barlingo.backend.security.JwtTokenProvider;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EstablishmentServiceImpl implements IEstablishmentService {

  @Autowired
  private EstablishmentRepository establishmentRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Override
  public List<Establishment> findAll() {
    return this.establishmentRepository.findAll();
  }

  @Override
  public Establishment save(Establishment establishment) {
    return this.establishmentRepository.save(establishment);
  }

  @Override
  public Establishment findById(Integer id) {
    return this.establishmentRepository.findById(id).orElse(null);
  }

  @Override
  public void delete(Establishment establishment) {
    this.establishmentRepository.delete(establishment);
  }

}
