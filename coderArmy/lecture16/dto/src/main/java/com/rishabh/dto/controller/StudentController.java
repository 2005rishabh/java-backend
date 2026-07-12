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

import com.rishabh.dto.entity.Student;
import com.rishabh.dto.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);

        return ResponseEntity.ok(createdStudent);
    }

    @GetMapping({ "", "/getAll" })
    public ResponseEntity<List<Student>> getStudent() {
        List<Student> std = studentService.getStudent();
        return ResponseEntity.ok(std);
    }

    @GetMapping("")
    public ResponseEntity<Student> getStudentById(@RequestParam Long id) {
        Student getStudent = studentService.getStudentById(id);
        return ResponseEntity.ok(getStudent);
    }

    @PutMapping("")
    public ResponseEntity<Student> updateStudent(@RequestParam Long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student expelled successfully");

    }

    @PatchMapping("")
    public ResponseEntity<String> softDelete(@RequestParam Long id) {
        studentService.softDelete(id);
        return ResponseEntity.ok("Soft deleted successfully");
    }
}
