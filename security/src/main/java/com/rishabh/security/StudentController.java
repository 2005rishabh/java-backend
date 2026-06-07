package com.rishabh.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping

public class StudentController {
    List<Student> students = new ArrayList<>();
    
}