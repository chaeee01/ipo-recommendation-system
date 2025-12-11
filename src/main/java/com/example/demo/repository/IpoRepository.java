package com.example.demo.repository;

import com.example.demo.entity.IPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface IpoRepository extends JpaRepository<IPO,Long> {

    @Query("""
        SELECT i FROM IPO i 
        JOIN i.company c
        JOIN i.underwriter u
        WHERE (:minRate IS NULL OR i.competitionRate >= :minRate)
          AND (:maxPrice IS NULL OR i.offeringPrice <= :maxPrice)
          AND (:market IS NULL OR i.market = :market)
          AND (:industry IS NULL OR c.industry = :industry)
          AND (:startDate IS NULL OR i.ipoDate >= :startDate)
          AND (:endDate IS NULL OR i.ipoDate <= :endDate)
        ORDER BY 
            CASE WHEN :sort = 'rateDesc' THEN i.competitionRate END DESC,
            CASE WHEN :sort = 'priceAsc' THEN i.offeringPrice END ASC
        """)
    List<IPO> advancedSearch(
            Double minRate, Integer maxPrice, String market,
            String industry, LocalDate startDate, LocalDate endDate, String sort
    );
}
