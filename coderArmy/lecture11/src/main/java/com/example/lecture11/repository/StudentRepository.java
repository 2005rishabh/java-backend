package com.example.lecture11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.lecture11.entity.Student;

@Component
public class StudentRepository {

    public Student saveStudent(Student reqStudent) {
        return null;
    }

}
