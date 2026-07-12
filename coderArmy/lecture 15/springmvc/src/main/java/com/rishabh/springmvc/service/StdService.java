package com.rishabh.springmvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rishabh.springmvc.entity.Student;
import com.rishabh.springmvc.repository.StdRepository;

@Service
public class StdService {
    private StdRepository stdRepository;

    public StdService(StdRepository stdRepository) {
        this.stdRepository = stdRepository;
    }

    private Student createStudent(Student stdReq) {
        return stdRepository.save(stdReq);
    }

    private Student getStudentById(Long id) {
        return stdRepository.findByID(id);
    }

    private List<Student> getAllStudents() {
        return stdRepository.findAll();
    }
    
}
