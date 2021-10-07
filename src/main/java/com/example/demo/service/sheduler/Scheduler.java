package com.example.demo.service.sheduler;

import com.example.demo.service.impl.CurrencyService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
@AllArgsConstructor
@EnableScheduling
public class Scheduler {
    private final CurrencyService currencyService;
    private static final Logger logger = LoggerFactory.getLogger(Scheduler.class);

    @Scheduled(cron = "0 0 0 * * *", zone="Asia/Almaty") //First day of every month
    private void vu20Scheduler() {
        logger.info("Saving todays rate started");
        currencyService.saveTodaysCurrency();
    }
}
