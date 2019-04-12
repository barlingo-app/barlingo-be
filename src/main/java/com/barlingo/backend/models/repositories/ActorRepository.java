package com.barlingo.backend.models.repositories;

import com.barlingo.backend.models.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
  Actor findByUserAccountId(Integer id);
}
