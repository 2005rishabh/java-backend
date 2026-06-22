package com.rishabh.revise.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishabh.revise.dto.StdRequest;
import com.rishabh.revise.dto.StdResponse;
import com.rishabh.revise.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor

public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StdResponse> createStudent(@RequestBody StdRequest stdRequest) {
        StdResponse stdResponse = studentService.createStudent(stdRequest);
        return ResponseEntity.ok(stdResponse);
    }

    @GetMapping
    public ResponseEntity<List<StdResponse>> getAllStudents() {
        List<StdResponse> stdResponse = studentService.getAllStudents();
        return ResponseEntity.ok(stdResponse);
    }

    @GetMapping("{/id}")
    public ResponseEntity<StdResponse> getStudentById(Long id) {
        StdResponse stdResponse = studentService.getStudentById(id);
        return ResponseEntity.ok(stdResponse);
    }

    @PutMapping("{/id}")
    public ResponseEntity<StdResponse> updateStudent(Long id, StdRequest request) {
        StdResponse stdResponse = studentService.updateStudent(id, request);
        return ResponseEntity.ok(stdResponse);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudent(Long id) {
        return ResponseEntity.ok("Student deleted successfully.");
    }
}
