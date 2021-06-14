package com.wenance.challenge.price.asyn;

import com.wenance.challenge.price.domain.Price;
import com.wenance.challenge.price.service.CEXLookupService;
import com.wenance.challenge.price.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
public class AppRunner{

    private final CEXLookupService cexLookupService;

    @Autowired
    private PriceService priceService;

    public AppRunner(CEXLookupService cexLookupService) {
        this.cexLookupService = cexLookupService;
    }

    @Scheduled(fixedRate = 10000)
    public void saveLastPrice(){
        CompletableFuture<Price> price = cexLookupService.findPrice();
        try {
            priceService.save(price.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
