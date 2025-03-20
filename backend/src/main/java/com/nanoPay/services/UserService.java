package com.nanoPay.services;

import com.nanoPay.models.AccountType;
import com.nanoPay.models.User;
import com.nanoPay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private User user;

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
    private boolean isEmailExists(String email) {
        Optional<User> existingUser = Optional.ofNullable(userRepository.findByEmail(email));
        return existingUser.isPresent();
    }
    private boolean isPhoneNumberExists(String phoneNumber) {
        Optional<User> existingUser = Optional.ofNullable(userRepository.findByPhoneNumber(phoneNumber));
        return existingUser.isPresent();
    }

}
