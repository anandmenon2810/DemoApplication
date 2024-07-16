package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("wallets") // Specify the collection name
public class Wallet {

    @Id
    private String walletId; // e.g., W12345
    private Double authorizedAmount;
    private List<PaymentMethod> paymentMethods;
    private LoyaltyDetails loyaltyDetails;
    private CashDetails cashDetails;
    private List<Transaction> transactions;
    private String memberId;

}