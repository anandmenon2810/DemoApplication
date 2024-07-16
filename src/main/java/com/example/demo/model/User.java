package com.example.demo.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
@Data
public class User {
    @Id
    private String _id;
    private String userId;
    private String password;
    private String memberId;

}