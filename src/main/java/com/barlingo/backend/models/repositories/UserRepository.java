package com.barlingo.backend.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.barlingo.backend.models.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
