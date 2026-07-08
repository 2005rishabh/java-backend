package com.example.lecture11.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lecture11.entity.Student;
import com.example.lecture11.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student ) {
        Student createdStudent = studentService.createStudent(student);

        return ResponseEntity.ok(createdStudent);        
    }

    // @GetMapping
    // public  getStudent() {
    //     List<Student> std;
    // }

    // @GetMapping("/{id}")
    // public void getStudentById() {

    // }

    // @DeleteMapping("/{id}")
    // public void deleteStudent() {

    // }

    // @PutMapping("/{id}")
    // public void updateStudent() {

    // }
}
