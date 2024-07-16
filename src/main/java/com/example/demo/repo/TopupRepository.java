package com.example.demo.repo;
import com.example.demo.model.Topup;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TopupRepository extends MongoRepository<Topup, String> {

}