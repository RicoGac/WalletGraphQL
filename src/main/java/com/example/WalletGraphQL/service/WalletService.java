package com.example.WalletGraphQL.service;

import com.example.WalletGraphQL.entities.Currency;
import com.example.WalletGraphQL.entities.Wallet;
import com.example.WalletGraphQL.repositories.CurrencyRepository;
import com.example.WalletGraphQL.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@Transactional
public class WalletService {
    @Autowired
    private WalletRepository wr;
    @Autowired
    private CurrencyRepository cr;
    public void loadData() throws IOException
    {
        URI uri= new ClassPathResource("currencies.data.csv").getURI();
        Path path= Paths.get(uri);
        List<String> lines = Files.readAllLines(path);

        for (int i=1;i<lines.size();i++)
        {

            String [] line= lines.get(i).split(";");

            Currency  c =  new Currency();
            c.setCode(line[0]);
            c.setName(line[1]);
            System.out.println("price : "+ line[2]);
            c.setSalePrice(Float.parseFloat( line[2]));
            c.setPurchasePrice(Double.parseDouble(line[3]));

            cr.save(c);

        }
        Stream.of("USD","EUR").forEach(currencyCode ->{
            Currency currency =cr.findById(currencyCode)
                    .orElseThrow(()->new RuntimeException(String.format(currencyCode, "Currency not found")) );

            Wallet wallet = new Wallet();
            wallet.setBalance(1000.0);
            wallet.setCurrency(currency);
            wallet.setCreatedAT(System.currentTimeMillis());
            wallet.setUserId("user1");
            wallet.setId(UUID.randomUUID().toString());
            wr.save(wallet);

        });
    }

}

