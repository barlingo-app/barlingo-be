package com.barlingo.backend.models.services;

import java.util.List;

import com.barlingo.backend.exception.CustomException;
import com.barlingo.backend.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barlingo.backend.models.entities.Establishment;
import com.barlingo.backend.models.repositories.EstablishmentRepository;


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
		return (List<Establishment>) this.establishmentRepository.findAll();
	}

	@Override
	public void save(Establishment establishment) {
		this.establishmentRepository.save(establishment);
	}

	@Override
	public Establishment findById(Integer id) {
		return this.establishmentRepository.findById(id).orElse(null);
	}

	@Override
	public Establishment findByUsername(String username) {
		return this.establishmentRepository.findByUsername(username);
	}

	@Override
	public void delete(Establishment establishment) {
		this.establishmentRepository.delete(establishment);
	}

	public String signin(String username, String password) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			return jwtTokenProvider.createToken(username, establishmentRepository.findByUsername(username).getRoles());
		} catch (AuthenticationException e) {
			throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

}
