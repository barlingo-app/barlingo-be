package com.barlingo.backend.models.repositories;

import com.barlingo.backend.models.entities.LanguageExchange;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LanguageExchangeRepository extends JpaRepository<LanguageExchange, Integer> {

  @Query("select ex from LanguageExchange ex where ex.establishment.id = :estId")
  Collection<LanguageExchange> findByEstId(@Param("estId") Integer estId);

  @Query("select ex from LanguageExchange ex join ex.participants p where p.id = :userId")
  List<LanguageExchange> findAllByUserId(@Param("userId") Integer userId);

}
