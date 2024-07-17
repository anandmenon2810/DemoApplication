package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private LocalDateTime date;
    private String item;
    private String experience; // e.g., STAY, WALLET
    private String payWith; // e.g., CASH, POINTS
    private Integer amount;
    private int pointsEarned;
}
