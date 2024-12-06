package com.snehal.test.dtos;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
@Builder
public class ExchangeRateResponse {
    private Map<String, BigDecimal> rates;
}
