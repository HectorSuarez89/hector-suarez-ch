package com.wenance.challenge.price.domain.dto;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class PriceDTO {
    LocalDateTime from;
    LocalDateTime until;
    double averangeValue;
    double maxValueStored;
    double percentageDiff;
}
