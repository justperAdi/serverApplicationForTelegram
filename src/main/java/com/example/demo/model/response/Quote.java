package com.example.demo.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    private Double USDEUR;
    private Double USDRUB;
//    private Double USwwwDRUB;
}
