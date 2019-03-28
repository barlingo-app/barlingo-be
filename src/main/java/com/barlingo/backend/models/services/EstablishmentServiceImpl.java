package com.barlingo.backend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barlingo.backend.models.entities.Establishment;
import com.barlingo.backend.models.repositories.EstablishmentRepository;


@Service
@Transactional
public class EstablishmentServiceImpl implements IEstablishmentService {

	@Autowired
	private EstablishmentRepository establishmentRepository;
	
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
	public void delete(Establishment establishment) {
		this.establishmentRepository.delete(establishment);
	}

}
