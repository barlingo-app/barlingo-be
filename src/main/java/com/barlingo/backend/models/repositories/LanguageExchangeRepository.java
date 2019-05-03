package com.barlingo.backend.models.repositories;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.barlingo.backend.models.entities.LanguageExchange;

public interface LanguageExchangeRepository extends JpaRepository<LanguageExchange, Integer> {

  @Query("select ex from LanguageExchange ex where ex.establishment.id = :estId order by moment asc")
  Collection<LanguageExchange> findByEstId(@Param("estId") Integer estId);

  @Query("select ex from LanguageExchange ex where ex.establishment.id = :estId and ex.moment > :moment order by moment asc")
  Collection<LanguageExchange> findByEstIdAndMomentAfter(@Param("estId") Integer estId,
      @Param("moment") LocalDateTime moment);


  @Query("select ex from LanguageExchange ex join ex.participants p where p.id = :userId order by moment asc")
  List<LanguageExchange> findAllByUserId(@Param("userId") Integer userId);

  @Query("select ex from LanguageExchange ex join ex.participants p where p.id = :userId and ex.moment > :moment order by moment asc")
  List<LanguageExchange> findAllByUserIdAndMomentAfter(@Param("userId") Integer userId,
      @Param("moment") LocalDateTime moment);

  List<LanguageExchange> findByMomentAfterOrderByMomentAsc(LocalDateTime date);

  List<LanguageExchange> findByOrderByMomentDesc();

}
