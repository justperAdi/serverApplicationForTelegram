package com.example.demo.service.impl;

import com.example.demo.model.Currency;
import com.example.demo.model.request.PeriodRequest;
import com.example.demo.model.response.CurrencyResponse;
import com.example.demo.model.response.Quote;
import com.example.demo.repo.CurrencyRepo;
import com.example.demo.service.iCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class CurrencyService implements iCurrencyService {

    @Autowired
    private CurrencyRepo currencyRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Currency addCurrency(Currency currency){
        return currencyRepo.save(currency);
    }

    @Override
    public void saveTodaysCurrency() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        ResponseEntity<CurrencyResponse> resp = restTemplate.getForEntity(
                "http://api.currencylayer.com/historical?access_key=5ad0f86d860fdf0390898bb5f551d58c&date="
                        + formatter.format(date),CurrencyResponse.class);

        CurrencyResponse cur = resp.getBody();

//        CurrencyResponse currency =restTemplate.getForObject(
//                "http://api.currencylayer.com/historical?access_key=5ad0f86d860fdf0390898bb5f551d58c&date="
//                        + formatter.format(date),CurrencyResponse.class);

//        List<Quote> quotes = currency.getQuotes();

        String eur = cur.getQuotes().toString().substring(cur.getQuotes().toString().indexOf("USDEUR") + 7);
        eur = eur.replaceAll("\\,.*", "");

        String rub = cur.getQuotes().toString().substring(cur.getQuotes().toString().indexOf("USDRUB") + 7);
        rub = rub.replaceAll("\\,.*", "");

        Currency toSave = Currency.builder()
                .date(date)
                .eur(Double.parseDouble(eur))
                .rub(Double.parseDouble(rub))
                .usd(1.0)
                .build();

        currencyRepo.save(toSave);

        System.out.println(eur);
        System.out.println(cur.getQuotes());

    }

    @Override
    public List<Currency> getLastDozen(String fromdate, String todate ) throws ParseException {
        Date fromDate=new SimpleDateFormat("yyyy-MM-dd").parse(fromdate.trim());
        String string1 = todate.trim() + " 23:59:59";
        Date toDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(string1);
        return currencyRepo.findLastDozen(fromDate, toDate);
    }
}
