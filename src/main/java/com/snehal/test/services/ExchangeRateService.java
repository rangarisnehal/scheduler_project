package com.snehal.test.services;

import com.snehal.test.models.Currency;

import java.util.List;

public interface ExchangeRateService {
    List<Currency> fetchLatestRates();
    void updateDatabaseRates(List<Currency> rates);
}
