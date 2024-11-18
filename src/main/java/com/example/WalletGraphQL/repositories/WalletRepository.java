package com.example.WalletGraphQL.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WalletGraphQL.entities.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, String> {
}
