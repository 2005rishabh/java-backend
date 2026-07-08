package com.example.lecture11.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lecture11.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
