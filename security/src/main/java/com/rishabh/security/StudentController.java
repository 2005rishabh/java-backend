package com.rishabh.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping

public class StudentController {
    List<Student> students = new ArrayList<>(List.of(
        new Student(1, "rishabh", 21, 98),
        new Student(2, "shivek", 16, 92),
        new Student(3, "sahil", 25, 68)
    ));
    
    @GetMapping("/students")
    public List<Student> getStudent() {
        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }


    @PostMapping("/students")
    public String createStudent(@RequestBody Student student) {
        //TODO: process POST request
        students.add(student);
        return "created successfully";
    }
    
}