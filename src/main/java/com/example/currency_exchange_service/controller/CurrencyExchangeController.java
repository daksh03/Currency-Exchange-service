package com.example.currency_exchange_service.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.currency_exchange_service.entity.CurrencyExchange;
import com.example.currency_exchange_service.repository.CurrencyExchangeRepo;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRepo currencyExchangeRepo;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(
	@PathVariable String from,
	@PathVariable String to) {
		
//		CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from ,to , BigDecimal.valueOf(50));
		CurrencyExchange currencyExchange = currencyExchangeRepo.findByFromAndTo(from, to);
		if(currencyExchange==null) {
			throw new RuntimeException("Unable to find data for "+from +"to" + to);
		}
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
		return currencyExchange;
	}

}
