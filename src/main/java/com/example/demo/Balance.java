package com.example.demo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Cash and Point Balance")
public class Balance {
    @Id
    private String _id;
    private String CashBalance;
    private String PointBalance;

    public String getCashBalance() {
        return CashBalance;
    }

    public void setCashBalance(String CashBalance) {
        this.CashBalance = CashBalance;
    }


    public String getPointBalance() {
        return PointBalance;
    }

    public void setPointBalance(String PointBalance) {
        this.PointBalance = PointBalance;
    }
}

