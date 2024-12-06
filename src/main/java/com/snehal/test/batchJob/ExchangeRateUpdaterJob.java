package com.snehal.test.batchJob;

import com.snehal.test.models.Currency;
import com.snehal.test.services.ExchangeRateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangeRateUpdaterJob extends AbstractBatchJob {
    private final ExchangeRateService exchangeRateService;

    public ExchangeRateUpdaterJob(ExchangeRateService service) {
        this.exchangeRateService = service;
    }

    @Override
    public void execute() {
        logJobStart();

        List<Currency> currencies = exchangeRateService.fetchLatestRates();
        exchangeRateService.updateDatabaseRates(currencies);

        logJobCompletion();
    }
}
