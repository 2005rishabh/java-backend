package com.jwt.security_with_jwt.conroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "Hello World";
    }
}
