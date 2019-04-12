package com.barlingo.backend.models.repositories;

import com.barlingo.backend.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  User findByUserAccountId(Integer id);

}
