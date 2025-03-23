package com.nanoPay.services;

import com.nanoPay.models.User;
import com.nanoPay.repository.UserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@Lazy
public class AuthService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JWTService jwtService;
    private User user;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JWTService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public User registerUser(User user) {

       if (isEmailExists(user.getEmail())) {
            throw new IllegalArgumentException("Email is already registered.");
        }
        if (isPhoneNumberExists(user.getPhoneNumber())) {
            throw new IllegalArgumentException("Phone number is already registered.");
        }

        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);

        return userRepository.save(user);
    }

    public String loginUser(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser == null) {
            throw new IllegalArgumentException("User not found.");
        }
        if (!passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            throw new IllegalArgumentException("Invalid password.");
        }
        return jwtService.generateToken(user.getEmail());
    }
    private boolean isEmailExists(String email) {
        Optional<User> existingUser = Optional.ofNullable(userRepository.findByEmail(email));
        return existingUser.isPresent();
    }
    private boolean isPhoneNumberExists(String phoneNumber) {
        Optional<User> existingUser = Optional.ofNullable(userRepository.findByPhoneNumber(phoneNumber));
        return existingUser.isPresent();
    }

}
