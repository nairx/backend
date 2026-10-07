package com.example.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.backend.dto.UserEditRequest;
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

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    public boolean deleteUser(Long id){
       userRepository.deleteById(id);
        return true;
    }

    public User updateUser(UserEditRequest request, Long id){
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User Not Found"));
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        return userRepository.save(user);
    }
}
