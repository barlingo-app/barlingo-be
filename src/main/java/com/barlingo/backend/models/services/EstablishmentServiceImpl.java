package com.barlingo.backend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barlingo.backend.exception.CustomException;
import com.barlingo.backend.models.entities.Establishment;
import com.barlingo.backend.models.repositories.EstablishmentRepository;
import com.barlingo.backend.security.JwtTokenProvider;

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
	public Establishment findByUsername(String username) {
		return this.establishmentRepository.findByUsername(username);
	}

	@Override
	public void delete(Establishment establishment) {
		this.establishmentRepository.delete(establishment);
	}

	@Override
	public String signin(String username, String password) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			Establishment establishment = establishmentRepository.findByUsername(username);
			return jwtTokenProvider.createToken(username,establishment.getId(), establishment.getRoles());
		} catch (AuthenticationException e) {
			throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

}
