package com.wenance.challenge.price.domain;

import lombok.Value;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Value
@Entity
public class Price {
    double id;
    float price;
    LocalDateTime time;

}
