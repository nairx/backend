package com.example.backend.controller;

import com.example.backend.dto.LoginRequest;
import com.example.backend.dto.LoginResponse;
import com.example.backend.entity.User;
import com.example.backend.security.JwtService;
import com.example.backend.service.AuthService;
import org.springframework.http.HttpHeaders;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseCookie;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
// @CrossOrigin
public class AuthController {

    private AuthService authService;
    private JwtService jwtService;

    public AuthController(AuthService authService, JwtService jwtService) {
        this.authService = authService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request, HttpServletResponse response) {
        User user = authService.login(request);
        String token = jwtService.generateToken(user.getEmail(), user.getRole());
        System.out.println(token);
        Cookie cookie = new Cookie("AUTH_TOKEN", token);
        cookie.setHttpOnly(true);
        cookie.setSecure(false); // true in HTTPS production
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60); // 1 hour
        response.addCookie(cookie);
        return new LoginResponse(user.getId(), user.getEmail(), user.getRole());

        // return authService.login(request);
    }

    // @PostMapping("/login")
    // public boolean login(@RequestBody LoginRequest request, HttpServletResponse
    // response) {
    // Cookie cookie = authService.login(request);
    // response.addCookie(cookie);
    // return true;

    // }

    @PostMapping("/logout")
    public String logout(HttpServletResponse response) {
        ResponseCookie cookie = ResponseCookie.from("AUTH_TOKEN", "")
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(0)
                .sameSite("Lax")
                .build();
                response.addHeader(HttpHeaders.SET_COOKIE,cookie.toString());

                return "Logout Successful";
    }

}
