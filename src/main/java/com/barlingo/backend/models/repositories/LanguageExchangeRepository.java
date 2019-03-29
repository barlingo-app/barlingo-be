package com.barlingo.backend.models.repositories;

import com.barlingo.backend.models.entities.LanguageExchange;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LanguageExchangeRepository extends JpaRepository<LanguageExchange, Integer> {
	
	@Query("select ex from LanguageExchange ex where ex.establishment.id = :estId")
	Collection<LanguageExchange> findByEstId(@Param("estId") Integer estId);

}
