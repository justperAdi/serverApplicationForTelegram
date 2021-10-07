package com.example.demo.service;

import com.example.demo.model.Currency;
import com.example.demo.model.request.PeriodRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface iCurrencyService {

    Currency addCurrency(Currency currency);
    void saveTodaysCurrency();
    List<Currency> getLastDozen(String fromDate, String todate) throws ParseException;

}
