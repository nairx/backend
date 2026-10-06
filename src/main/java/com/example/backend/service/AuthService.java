package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.dto.LoginRequest;
import com.example.backend.entity.User;
import com.example.backend.repository.UserRepository;

@Service
public class AuthService {
    private UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user) {
        return userRepository.save(user);
    }

    public User login(LoginRequest request) {
        System.out.println(request.getEmail());
        System.out.println(request.getPasswod());
        return userRepository.findByEmailAndPassword(request.getEmail(), request.getPasswod())
                .orElseThrow(() -> new RuntimeException("User not found"));

    }
}
