package com.example.demo.repo;

import com.example.demo.model.Wallet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends MongoRepository<Wallet, String> {
    List<Wallet> findByMemberId(String memberId);
}
