package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class HelloController {
    @RequestMapping("/")
    public String greet() {
        System.out.println("Hello World");
        return "hello world";
    }
}
