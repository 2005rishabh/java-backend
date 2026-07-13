package com.rishabh.dto.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rishabh.dto.dtos.ReqDto;
import com.rishabh.dto.dtos.ResDto;
import com.rishabh.dto.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResDto> createStudent(@RequestBody ReqDto student) {
        ResDto createdStudent = studentService.createStudent(student);

        return ResponseEntity.ok(createdStudent);
    }

    @GetMapping({ "", "/getAll" })
    public ResponseEntity<List<ResDto>> getStudent() {
        List<ResDto> std = studentService.getStudent();
        return ResponseEntity.ok(std);
    }

    @GetMapping("")
    public ResponseEntity<ResDto> getStudentById(@RequestParam Long id) {
        ResDto getStudent = studentService.getStudentById(id);
        return ResponseEntity.ok(getStudent);
    }

    @PutMapping("")
    public ResponseEntity<ResDto> updateStudent(@RequestParam Long id, @RequestBody ReqDto student) {
        ResDto updatedStudent = studentService.updateStudent(id, student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student expelled successfully");

    }

    @PatchMapping("")
    public ResponseEntity<ResDto> softDelete(@RequestParam Long id) {
        ResDto deletedStudent = studentService.softDelete(id);
        return ResponseEntity.ok(deletedStudent);
    }
}
