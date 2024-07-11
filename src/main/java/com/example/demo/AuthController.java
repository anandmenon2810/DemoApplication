package com.example.demo;
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
    public boolean login(@RequestBody User loginUser) {
        Optional<User> userOpt = userRepository.findByUserId(loginUser.getUserId());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            System.out.println(user.getPassword().equals(loginUser.getPassword()));
            return user.getPassword().equals(loginUser.getPassword());
        }
        return false;
    }
}
