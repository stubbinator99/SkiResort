package com.skiresort.db;

import com.skiresort.models.Pass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassRepository extends JpaRepository<Pass, Long> {
    @Query("SELECT p FROM Pass p WHERE p.passId = ?1")
    Optional<Pass> findPassById(String id);

    @Query("SELECT p FROM Pass p WHERE p.username = ?1")
    List<Pass> findPassesForUser(String username);

    @Query(nativeQuery = true,
        value = "SELECT * FROM passes WHERE username = ?1 " +
            "ORDER BY CASE " +
                "WHEN start_date >= CURRENT_DATE THEN start_date " +
                "ELSE 'infinity'::date " +
            "END, " +
            "start_date DESC LIMIT 1")
    Optional<Pass> findSoonestPassForUser(String username);
}
