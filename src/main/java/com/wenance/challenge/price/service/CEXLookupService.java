package com.wenance.challenge.price.service;

import com.wenance.challenge.price.domain.Price;

import java.util.concurrent.CompletableFuture;

public interface CEXLookupService {

    CompletableFuture<Price> findPrice();
}
