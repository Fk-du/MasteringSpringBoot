package com.fkadu.microservices.curency_conversion_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CurencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurencyConversionServiceApplication.class, args);
	}

}
