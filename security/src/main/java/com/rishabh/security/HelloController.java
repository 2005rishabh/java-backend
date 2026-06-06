package com.rishabh.security;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController

public class HelloController {
    @GetMapping("/")
    public String Hello() {
        return "Welcome to Rishabh";
    }
    
}
