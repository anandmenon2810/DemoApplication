package com.example.demo;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface BalanceRepository extends MongoRepository<User, String> {
    Optional<Balance> findByUserId(String CashBalance);
}

