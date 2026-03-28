package com.ecommerce.controller;

import com.ecommerce.entity.User;
import com.ecommerce.service.AuthService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Signup
    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return authService.signup(user);
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            User loggedInUser = authService.login(user.getEmail(), user.getPassword());
            return ResponseEntity.ok(loggedInUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}