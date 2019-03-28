package com.barlingo.backend.models.services;

import java.util.Collection;

import com.barlingo.backend.models.entities.Establishment;

public interface IEstablishmentService {

	Collection<Establishment> findAll();
	
	void save(Establishment establishment);
	
	Establishment findById(Integer id);
	
	void delete(Establishment establishment);
}
