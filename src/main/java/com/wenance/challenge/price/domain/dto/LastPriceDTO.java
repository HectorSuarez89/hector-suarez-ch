package com.wenance.challenge.price.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class LastPriceDTO {
    String lprice;
    String curr1;
    String curr2;
}
