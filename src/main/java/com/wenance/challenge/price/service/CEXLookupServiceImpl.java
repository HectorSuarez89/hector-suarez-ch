package com.wenance.challenge.price.service;

import com.wenance.challenge.price.domain.Price;
import com.wenance.challenge.price.domain.dto.LastPriceDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CEXLookupServiceImpl implements CEXLookupService{

    private final RestTemplate restTemplate;

    @Value("${lastprice.get.uri}")
    private String cexUrl;

    public CEXLookupServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);
    }

    @Async
    @Override
    public CompletableFuture<Price> findPrice() {
        LastPriceDTO result = restTemplate.getForObject(cexUrl, LastPriceDTO.class);
        Price price = new Price(0,Float.valueOf(result.getLprice()), LocalDateTime.now().withNano(0));
        return CompletableFuture.completedFuture(price);
    }
}
