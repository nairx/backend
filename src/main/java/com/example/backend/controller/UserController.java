package com.example.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.example.backend.dto.UserEditRequest;
import com.example.backend.entity.User;
import com.example.backend.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {
    private UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return true;
    }

    @PutMapping("/update/{id}")
    public User updateUser(@RequestBody UserEditRequest request, @PathVariable Long id) {
        return userService.updateUser(request, id);
    }

}
