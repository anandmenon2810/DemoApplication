package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repo.TopupRepository;
import com.example.demo.repo.TransactionRepository;
import com.example.demo.repo.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class WalletService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction getTransaction(String walletid) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(walletid);
        return optionalTransaction.orElse(null);
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Autowired
    private TopupRepository topupRepository;

    public Topup getTopup(String topuprequest) {
        Optional<Topup> optionalTopup = topupRepository.findById(topuprequest);
        return optionalTopup.orElse(null);

    }


    @Autowired
    private WalletRepository walletRepository;

    // Retrieve a wallet by its ID
    public Wallet getWalletById(String walletId) {
        Optional<Wallet> wallet = walletRepository.findById(walletId);
        return wallet.orElse(null);
    }

    // Retrieve transactions for a specific wallet
    public List<Transaction> getTransactionsByWalletId(String walletId) {
        Optional<Wallet> wallet = walletRepository.findById(walletId);
        return wallet.map(Wallet::getTransactions).orElse(null);
    }


    // Create a new transaction
    public Transaction createTransaction(String walletId, Transaction transaction) {
        Optional<Wallet> walletOptional = walletRepository.findById(walletId);
        if (walletOptional.isPresent()) {
            Wallet wallet = walletOptional.get();
            wallet.getTransactions().add(transaction);
            walletRepository.save(wallet);
            return transaction;
        }
        return null;
    }

    // method to retrieve all wallets by user ID
    public List<Wallet> getWalletsByUserId(String memberId) {
        return walletRepository.findByMemberId(memberId);
    }
    public boolean topUpWallet(String walletId, TopUpRequest topUpRequest) {
        Optional<Wallet> walletOptional = walletRepository.findById(walletId);
        if (walletOptional.isPresent()) {
            Wallet wallet = walletOptional.get();
            if (topUpRequest.getPaymentType().equals("CreditCard")){
                wallet.getCashDetails().setCashBalance(wallet.getCashDetails().getCashBalance() + topUpRequest.getAmount());
            }
            else {
                wallet.getLoyaltyDetails().setBalancePoints(wallet.getLoyaltyDetails().getBalancePoints() + topUpRequest.getAmount());
            }
            // Create a new transaction for the top-up
            Transaction transaction = new Transaction();
            transaction.setAmount(topUpRequest.getAmount());
            transaction.setExperience("WALLET");
            transaction.setDate(LocalDateTime.now());

            // Add the transaction to the wallet
            wallet.getTransactions().add(transaction);
            walletRepository.save(wallet);
            return true;
        }
        return false;
    }
}
