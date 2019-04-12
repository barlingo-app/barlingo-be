package com.barlingo.backend.models.repositories;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.barlingo.backend.models.entities.Establishment;

public interface EstablishmentRepository extends JpaRepository<Establishment, Integer> {

  @Query("select est from Establishment est join est.subscription sub where sub.finishMoment > :date")
  public List<Establishment> findByDateGreater(@Param("date") LocalDateTime date);

}
