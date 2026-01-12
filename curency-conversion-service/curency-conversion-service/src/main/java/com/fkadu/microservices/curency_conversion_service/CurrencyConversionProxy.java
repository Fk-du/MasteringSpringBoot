package com.fkadu.microservices.curency_conversion_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "currency-exchange",url = "localhost:8000")
public interface CurrencyConversionProxy {
    @GetMapping("/from/{from}/to/{to}")
    public CurrencyConversion retrieveCurrencyExchange(
            @PathVariable String from,
            @PathVariable String to);
}
