package com.rishabh.springmvc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishabh.springmvc.entity.Student;
import com.rishabh.springmvc.service.StdService;

@RestController
@RequestMapping

public class StdController {
    private StdService stdService;

    public StdController(StdService stdService) {
        this.stdService = stdService;
    }

    public ResponseEntity<Student> createStudent(Student stdReq) {
        Student std = stdService.createStudent(stdReq);
        return ResponseEntity.ok(std);
    }

    public ResponseEntity<Student> getStudentById(Long id) {
        return ResponseEntity.ok(stdService.getStudentById(id));
    }

    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(stdService.getAllStudents());
    }
}
