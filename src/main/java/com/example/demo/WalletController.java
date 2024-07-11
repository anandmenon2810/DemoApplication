package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private BalanceRepository balanceRepository;


    public WalletController(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    @PostMapping("/summary")
    public String summary(@RequestBody Balance cashBalance) {

        return "summary";
    }
    @PostMapping("/details")
    public boolean details(@RequestBody User loginUser) {

        return false;
    }
    @PostMapping("/transactions")
    public boolean transactions(@RequestBody User loginUser) {

        return false;
    }
    @PostMapping("/pay")
    public boolean pay(@RequestBody User loginUser) {

        return false;
    }
}
