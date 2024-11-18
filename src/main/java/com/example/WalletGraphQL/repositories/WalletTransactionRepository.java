package com.example.WalletGraphQL.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WalletGraphQL.entities.WalletTransaction;

public interface WalletTransactionRepository extends JpaRepository<WalletTransaction, String> {
}
