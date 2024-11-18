package com.example.WalletGraphQL.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WalletGraphQL.entities.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, String> {
}
