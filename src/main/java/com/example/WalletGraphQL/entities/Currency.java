package com.example.WalletGraphQL.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Currency {
    @Id
    private String code;
    private String name;
    private String Symbol;
    private double salePrice;
    private double purchasePrice;

}
