package com.example.demo.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.security.access.AccessDeniedException;

@ControllerAdvice
public class SecurityControllerAdvice {

    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDeniedException() {
        return "redirect:/products";
    }
}