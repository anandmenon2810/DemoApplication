package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentMethod {

    private String cardType; // e.g., VISA, MASTERCARD
    private String cardNumber;
    private Double balance;
}
