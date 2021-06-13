package com.wenance.challenge.price.service;

import com.wenance.challenge.price.domain.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceService {
    Price findByTime(LocalDateTime localDateTime);
    List<Price> findByTimeBetween(LocalDateTime from, LocalDateTime until);
}
