package com.wenance.challenge.price.service;

import com.wenance.challenge.price.domain.Price;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService{

    @Override
    public Price findByTime(LocalDateTime localDateTime) {
        return null;
    }

    @Override
    public List<Price> findByTimeBetween(LocalDateTime from, LocalDateTime until) {
        return null;
    }
}
