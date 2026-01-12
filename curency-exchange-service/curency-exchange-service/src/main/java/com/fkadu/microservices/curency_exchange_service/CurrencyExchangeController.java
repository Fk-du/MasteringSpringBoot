package com.fkadu.microservices.curency_exchange_service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Currency Exchange not found"
            );
        }

        return currencyExchange;
    }

    @PostMapping("/create")
    public CurrencyExchange createCurrencyExchange(@RequestBody CurrencyExchange currencyExchange) {

        return currencyExchangeRepository.save(currencyExchange);
    }
}

