package com.fkadu.microservices.limits_service.controller;

import com.fkadu.microservices.limits_service.been.Limits;
import com.fkadu.microservices.limits_service.config.Configuration;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LimitController {

    private final Configuration configuration;
    @GetMapping("/limits")
    public Limits retriveLimits(){
        return new Limits(configuration.getMinimum(),
                configuration.getMaximum());
//        return new Limits(1,100);
    }
}
