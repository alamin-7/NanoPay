package com.nanoPay.controllers;

import com.nanoPay.models.User;
import com.nanoPay.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private AuthService authService;

    public UserController (AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return authService.registerUser(user);
    }
    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
          return authService.loginUser(user);
    }
}
