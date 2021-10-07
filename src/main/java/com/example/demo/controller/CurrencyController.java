package com.example.demo.controller;

import com.example.demo.model.Currency;
import com.example.demo.model.request.PeriodRequest;
import com.example.demo.service.impl.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @PostMapping("/add")
    public Currency add(@RequestBody Currency currency) {
        return currencyService.addCurrency(currency);
    }

    @GetMapping("/by/date")
    public void saveTodayRate(@RequestBody Currency currency) {
        currencyService.saveTodaysCurrency();
    }

    @GetMapping("/last/dozen/{fromdate}/{todate}")
    public List<Currency> getlastDozen(@PathVariable String fromdate,@PathVariable String todate) throws ParseException {
        return currencyService.getLastDozen(fromdate, todate);
    }

}
