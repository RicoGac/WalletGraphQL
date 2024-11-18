package com.example.WalletGraphQL.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WalletGraphQL.entities.Currency;
import com.example.WalletGraphQL.entities.Wallet;
import com.example.WalletGraphQL.repositories.CurrencyRepository;
import com.example.WalletGraphQL.repositories.WalletRepository;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/graphql")
public class WalletGraphQLController {
    @Autowired
    private WalletRepository walletRepo;

    @Autowired
    private CurrencyRepository currencyRepo;

    @QueryMapping
    public List<Wallet> userWallets() {
        return walletRepo.findAll();
    }

    @QueryMapping
    public Wallet findWalletById(@Argument String id) {
        return walletRepo.findById(id).orElse(null);
    }

    @QueryMapping
    public List<Currency> listCurrencies() {
        return currencyRepo.findAll();
    }


    @MutationMapping
    public Wallet addWallet(@Argument String userId, @Argument Double balance, @Argument String currencyCode) {
        Currency currency = currencyRepo.findById(currencyCode).orElseThrow();
        Wallet wallet = Wallet.builder()
                .id(UUID.randomUUID().toString())
                .UserId(userId)
                .balance(balance)
                .currency(currency)
                .createdAT(System.currentTimeMillis())
                .build();
        return walletRepo.save(wallet);
    }
}