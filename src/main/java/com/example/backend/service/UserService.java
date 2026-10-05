package com.example.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.backend.entity.User;
import com.example.backend.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User createUser( User user) {
        return userRepository.save(user);
    }
}
