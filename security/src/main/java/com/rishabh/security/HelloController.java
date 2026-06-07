package com.rishabh.security;

import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;

@RestController

public class HelloController {
    @GetMapping("/")
    public String Hello(HttpServletRequest request) {
        return "Welcome to Rishabh " + request.getSession().getId();
    }

}
