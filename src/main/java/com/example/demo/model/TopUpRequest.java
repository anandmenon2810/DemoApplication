package com.example.demo.model;

import lombok.Data;

@Data
public class TopUpRequest {
    private Integer amount;
    private String paymentType; // Assuming each payment method can be uniquely identified

}