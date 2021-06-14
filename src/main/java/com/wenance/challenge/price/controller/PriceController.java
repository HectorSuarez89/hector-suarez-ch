package com.wenance.challenge.price.controller;

import com.wenance.challenge.price.domain.Price;
import com.wenance.challenge.price.domain.dto.PriceDTO;
import com.wenance.challenge.price.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping("/")
    public ResponseEntity<Price> getByTime(
            @RequestParam(name = "time",required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime time
    ){
        return priceService.findByTime(time)
                .map(price -> new ResponseEntity<>(price, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/averange")
    public ResponseEntity<PriceDTO> getByTimeBetween(
            @RequestParam(name = "from",required = true)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime from,
            @RequestParam(name = "until",required = true)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime until
    ){
        return priceService.findByTimeBetween(from, until)
                .map(prices -> new ResponseEntity<>(prices, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
