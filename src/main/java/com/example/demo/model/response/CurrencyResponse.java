package com.example.demo.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyResponse {

    private boolean success;

    private Date date;

//    private Double source;

    private Object quotes;


}
