package com.example.student_app;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class StudentController {

    @RequestMapping("/")
    List<Student> getStudents() {
        return List.of(
                new Student(1, "rishabh", 21),
                new Student(2, "shivek", 21),
                new Student(3, "shobhit", 21),
                new Student(4, "sahil", 21));
    }
}
