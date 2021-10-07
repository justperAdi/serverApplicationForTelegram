package com.example.demo.repo;

import com.example.demo.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CurrencyRepo extends JpaRepository<Currency, Long> {
    @Query(value = "select * from currency c\n" +
            "where  c.date between :fromDate and :toDate", nativeQuery = true)
    List<Currency> findLastDozen(Date fromDate, Date toDate);
}
