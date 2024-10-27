package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; 

    public void registerUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Пользователь с данным именем уже существует!");
        }
        if  (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Пользователь с данной почтой уже существует!");
        }
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            throw new RuntimeException("Пароли не совпадают!");
        }
        
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setConfirmPassword(null);
        userRepository.save(user);
    }
}
