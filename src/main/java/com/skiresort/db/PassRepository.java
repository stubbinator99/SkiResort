package com.skiresort.db;

import com.skiresort.models.Pass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassRepository extends JpaRepository<Pass, Long> {
    @Query("SELECT p FROM Pass p WHERE p.passId = ?1")
    Optional<Pass> findById(String id);
}
