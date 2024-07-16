package com.example.demo.controller;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserRepository userRepository;


    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public User login(@RequestBody User loginUser) {
        Optional<User> userOpt = userRepository.findByUserId(loginUser.getUserId());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            System.out.println(user.getPassword().equals(loginUser.getPassword()));
            if (user.getPassword().equals(loginUser.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
