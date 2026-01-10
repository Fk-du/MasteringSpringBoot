package com.fkadu.microservices.curency_exchange_service;

import com.fkadu.microservices.curency_exchange_service.CurrencyExchange;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency-exchange")
@RequiredArgsConstructor
public class CurrencyExchangeController {

    private final Environment environment;
    private final CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange retrieveCurrencyExchange(
            @PathVariable String from,
            @PathVariable String to) {

        CurrencyExchange currencyExchange =
                currencyExchangeRepository.findByFromAndTo(from, to);

        if (currencyExchange == null) {
            throw new RuntimeException("Currency Exchange not found");
        }

        return currencyExchange;
    }

    @PostMapping("/create")
    public CurrencyExchange createCurrencyExchange(@RequestBody CurrencyExchange currencyExchange) {

        return currencyExchangeRepository.save(currencyExchange);
    }
}

