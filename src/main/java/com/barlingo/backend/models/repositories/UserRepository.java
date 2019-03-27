package com.barlingo.backend.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barlingo.backend.models.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
