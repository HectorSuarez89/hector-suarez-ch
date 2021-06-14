package com.wenance.challenge.price.repository;

import com.wenance.challenge.price.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {
    Optional<Price> findByTime(LocalDateTime localDateTime);
    Optional<List<Price>> findByTimeBetween(LocalDateTime from, LocalDateTime until);
}
