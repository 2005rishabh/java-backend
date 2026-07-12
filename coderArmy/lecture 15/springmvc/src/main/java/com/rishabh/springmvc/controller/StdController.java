package com.rishabh.springmvc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishabh.springmvc.entity.Student;
import com.rishabh.springmvc.service.StdService;

@RestController
@RequestMapping("/students")

public class StdController {
    private StdService stdService;

    public StdController(StdService stdService) {
        this.stdService = stdService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student stdReq) {
        Student std = stdService.createStudent(stdReq);
        return ResponseEntity.ok(std);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(stdService.getStudentById(id));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(stdService.getAllStudents());
    }
}
