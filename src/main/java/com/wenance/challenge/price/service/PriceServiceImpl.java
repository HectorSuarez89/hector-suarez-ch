package com.wenance.challenge.price.service;

import com.wenance.challenge.price.domain.Price;
import com.wenance.challenge.price.domain.dto.PriceDTO;
import com.wenance.challenge.price.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService{

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public Optional<Price> findByTime(LocalDateTime localDateTime) {
        return priceRepository.findByTime(localDateTime);
    }

    @Override
    public Optional<PriceDTO> findByTimeBetween(LocalDateTime from, LocalDateTime until) {
        Optional<List<Price>> prices = priceRepository.findByTimeBetween(from, until);
        double avg = findAvgFromList(prices);
        double max = findMaxPriceFromList(prices);
        float diffPercentage = calculateDiffPercentage(avg, max);
        return Optional.of(new PriceDTO(from, until, avg, max, diffPercentage));
    }

    private double findMaxPriceFromList(Optional<List<Price>> prices) {
        return prices.get().stream().mapToDouble(Price::getPrice).max().orElse(Double.NaN);
    }

    private double findAvgFromList(Optional<List<Price>> prices) {
        return prices.get().stream().mapToDouble(Price::getPrice).average().orElse(Double.NaN);
    }

    private float calculateDiffPercentage(double avg, double max){
        return (float) ((avg * 100) / max) - 100;
    }

    public Price save(Price price){
        return priceRepository.save(price);
    }
}
