package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.User;
import com.example.demo.services.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/products";
        }
        return "login";
    }

    @GetMapping("/register")
    public String register(Authentication authentication, Model model) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/products";
        }
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        try {
            userService.registerUser(user);
            return "redirect:/login";
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "register";
        }       
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/products";
    }
}