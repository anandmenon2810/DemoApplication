package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
        (collection = "Topup")
@NoArgsConstructor
@AllArgsConstructor

public class Topup {
    @Id
    private String _id;
    private String creditCardbalance;
    private String authorizedBalance;
    private String points;
}
