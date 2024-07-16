package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletController {


    @Autowired
    private WalletService walletService;


    @GetMapping("/{walletId}")
    public ResponseEntity<Wallet> getWalletById(@PathVariable String walletId) {
        Wallet wallet = walletService.getWalletById(walletId);
        if (wallet != null) {
            return ResponseEntity.ok(wallet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Retrieve transaction history for a wallet
    @GetMapping("/{walletId}/transactions")
    public ResponseEntity<List<Transaction>> getTransactionsByWalletId(@PathVariable String walletId) {
        List<Transaction> transactions = walletService.getTransactionsByWalletId(walletId);
        if (transactions != null) {
            return ResponseEntity.ok(transactions);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Top up a wallet with a chosen payment method
    @PostMapping("/{walletId}/topup")
    public ResponseEntity<Void> topUpWallet(@PathVariable String walletId, @RequestBody TopUpRequest topUpRequest) {
        boolean success = walletService.topUpWallet(walletId, topUpRequest);
        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    // Create a new transaction
    @PostMapping("/{walletId}/transactions")
    public ResponseEntity<Transaction> createTransaction(@PathVariable String walletId, @RequestBody Transaction transaction) {
        Transaction createdTransaction = walletService.createTransaction(walletId, transaction);
        if (createdTransaction != null) {
            return ResponseEntity.ok(createdTransaction);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    // retrieve all wallets for a specific user
    @GetMapping
    public ResponseEntity<List<Wallet>> getWalletsByUserId(@RequestParam(name = "memberId") String memberId) {
        List<Wallet> wallets = walletService.getWalletsByUserId(memberId);
        if (wallets != null && !wallets.isEmpty()) {
            return ResponseEntity.ok(wallets);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}