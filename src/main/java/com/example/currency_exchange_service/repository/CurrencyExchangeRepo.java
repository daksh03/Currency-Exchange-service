package com.example.currency_exchange_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.currency_exchange_service.entity.CurrencyExchange;

public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchange,Long> {

	CurrencyExchange findByFromAndTo(String from, String to);
}
