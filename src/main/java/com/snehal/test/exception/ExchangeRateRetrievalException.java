package com.snehal.test.exception;

public class ExchangeRateRetrievalException extends RuntimeException {
    public ExchangeRateRetrievalException(String message, Throwable cause) {
        super(message, cause);
    }
}
