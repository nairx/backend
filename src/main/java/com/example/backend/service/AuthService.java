package com.example.backend.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.backend.dto.LoginRequest;
import com.example.backend.entity.User;
import com.example.backend.repository.UserRepository;
import com.example.backend.security.JwtService;

import jakarta.servlet.http.Cookie;

@Service
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    public User register(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    public User login(LoginRequest request) {
        System.out.println(request.getEmail());
        System.out.println(request.getPasswod());
        return userRepository.findByEmailAndPassword(request.getEmail(),
                request.getPasswod())
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // public Cookie login(LoginRequest request) {
    // User user = userRepository.findByEmailAndPassword(request.getEmail(),
    // request.getPasswod())
    // .orElseThrow(() -> new RuntimeException("User not found"));
    // String token = jwtService.generateToken(user.getEmail(), user.getRole());

    // Cookie cookie = new Cookie("AUTH_TOKEN", token);

    // cookie.setHttpOnly(true);
    // cookie.setSecure(false); // true in HTTPS production
    // cookie.setPath("/");
    // cookie.setMaxAge(60 * 60); // 1 hour

    // // System.out.println(token);
    // return cookie;
    // }

}
