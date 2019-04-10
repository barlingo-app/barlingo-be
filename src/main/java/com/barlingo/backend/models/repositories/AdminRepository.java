package com.barlingo.backend.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.barlingo.backend.models.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
