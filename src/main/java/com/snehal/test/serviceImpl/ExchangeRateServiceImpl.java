package com.snehal.test.serviceImpl;

import com.snehal.test.exception.ExchangeRateRetrievalException;
import com.snehal.test.models.Currency;
import com.snehal.test.dtos.ExchangeRateResponse;
import com.snehal.test.repositories.CurrencyRepository;
import com.snehal.test.services.ExchangeRateService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final RestTemplate restTemplate;
    private final CurrencyRepository currencyRepository;

    @Value("${exchange_rate_uri}")
    private String EXCHANGE_RATE_API_URL;

    public ExchangeRateServiceImpl(RestTemplate restTemplate, CurrencyRepository currencyRepository) {
        this.restTemplate = restTemplate;
        this.currencyRepository = currencyRepository;
    }

    @Override
    public List<Currency> fetchLatestRates() {
        try {
            ExchangeRateResponse response = restTemplate.getForObject(
                    EXCHANGE_RATE_API_URL,
                    ExchangeRateResponse.class
            );

            return convertResponseToCurrencies(response);
        } catch (RestClientException e) {
            throw new ExchangeRateRetrievalException("Failed to fetch exchange rates", e);
        }
    }

    @Override
    @Transactional
    public void updateDatabaseRates(List<Currency> rates) {
        currencyRepository.saveAll(rates);
    }

    private List<Currency> convertResponseToCurrencies(ExchangeRateResponse response) {
        return response.getRates().entrySet().stream()
                .map(entry -> Currency.builder()
                        .code(entry.getKey())
                        .rate(entry.getValue())
                        .lastUpdated(LocalDateTime.now())
                        .build())
                .collect(Collectors.toList());
    }
}
