package com.barlingo.backend.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barlingo.backend.models.entities.User;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByUsername(String username);

    User findByUsername(String username);

    @Transactional
    void deleteByUsername(String username);

}
