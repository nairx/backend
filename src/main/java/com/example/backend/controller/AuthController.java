package com.example.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.backend.dto.LoginRequest;
import com.example.backend.entity.User;
import com.example.backend.service.AuthService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest request){
        return authService.login(request);

    }

}
