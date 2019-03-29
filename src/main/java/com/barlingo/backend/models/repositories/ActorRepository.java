package com.barlingo.backend.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barlingo.backend.models.entities.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

}
