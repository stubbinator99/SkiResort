package com.skiresort.db;

import com.skiresort.models.Pass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassRepository extends JpaRepository<Pass, Long> {
    /*@Query("SELECT p FROM Pass p WHERE p.passId = ?1")
    Optional<Pass> findPassById(String id);*/

    @Query(value =
        "SELECT p.*, pr.* FROM passes p JOIN pass_prices pr ON p.price_id = pr.price_id WHERE p.pass_id = ?1", nativeQuery = true)
        /*"SELECT p.pass_id AS pass_id, " +
            "p.username AS username, " +
            "p.start_date AS start_date, " +
            "p.end_date AS end_date, " +
            "pr.price_id AS price_id, " +
            "pr.year AS year, " +
            "pr.pass_type AS pass_type, " +
            "pr.pass_category AS pass_category, " +
            "pr.price AS price_amount " +
            "FROM passes p " +
            "JOIN pass_prices pr ON p.price_id = pr.price_id " +
            "WHERE p.pass_id = ?1",
        nativeQuery = true)*/
    Optional<Pass> findPassById(String passId);

    @Query(value = "SELECT p.*, pr.* FROM passes p JOIN pass_prices pr ON p.price_id = pr.price_id WHERE p.username = ?1", nativeQuery = true)
    List<Pass> findPassesWithPricesForUsername(String username);

    @Query(nativeQuery = true,
        value = "SELECT p.*, pr.* " +
            "FROM passes p JOIN pass_prices pr " +
            "ON p.price_id = pr.price_id WHERE username = ?1 " +
            "ORDER BY CASE " +
                "WHEN start_date >= CURRENT_DATE THEN start_date " +
                "ELSE 'infinity'::date " +
            "END, " +
            "start_date DESC LIMIT 1")
    Optional<Pass> findSoonestPassForUser(String username);
}
