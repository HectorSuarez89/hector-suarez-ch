package com.wenance.challenge.price.service;

import com.wenance.challenge.price.domain.Price;
import com.wenance.challenge.price.domain.dto.PriceDTO;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceService {
    Optional<Price> findByTime(LocalDateTime localDateTime);
    Optional<PriceDTO> findByTimeBetween(LocalDateTime from, LocalDateTime until);
    Price save(Price price);
}
