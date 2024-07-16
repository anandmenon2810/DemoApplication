package com.example.demo.model;

import lombok.Getter;


@Getter
public enum PaymentEnum {
    CASH("CASH"),
    POINTS("POINTS");
    private final String paymentType;

    PaymentEnum(String paymentType) {
        this.paymentType = paymentType;
    }
}
