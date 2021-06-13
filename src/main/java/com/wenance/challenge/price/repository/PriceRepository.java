package com.wenance.challenge.price.repository;

import com.wenance.challenge.price.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Double, Price> {
    Price findByTime(LocalDateTime localDateTime);
    List<Price> findByTimeBetween(LocalDateTime from, LocalDateTime until);
}
