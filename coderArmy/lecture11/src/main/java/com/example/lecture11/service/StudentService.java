package com.example.lecture11.service;

import org.springframework.stereotype.Service;

import com.example.lecture11.entity.Student;
import com.example.lecture11.repository.StudentRepository;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student reqStudent) {
        Student createdStudent = studentRepository.save(reqStudent);
        return createdStudent;
    }

    // public Student getStudent() {
    //     Student createdStudent = studentRepository.findAll();
    //     return createdStudent;
    // }

    public Student getStudentById(Long id) {
        Student createdStudent = studentRepository.findById(id).
        orElseThrow(() -> new RuntimeException(
            "Not found by id " + id
        ));
        return createdStudent;
    }

    // public Student deleteStudent(Long id) {
    //     Student createdStudent = studentRepository.saveStudent(reqStudent);
    //     return createdStudent;
    // }

    // public Student updateStudent(Long id) {
    //     Student createdStudent = studentRepository.saveStudent(reqStudent);
    //     return createdStudent;
    // }

}
