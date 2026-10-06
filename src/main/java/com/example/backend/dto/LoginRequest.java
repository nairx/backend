package com.example.backend.dto;

public class LoginRequest {
    private String email;
    private String passwod;

    public LoginRequest(String email,String password){
        this.email = email;
        this.passwod = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswod() {
        return passwod;
    }

    public void setPasswod(String passwod) {
        this.passwod = passwod;
    }

    
}
