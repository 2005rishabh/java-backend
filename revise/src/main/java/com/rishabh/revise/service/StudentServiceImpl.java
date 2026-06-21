package com.rishabh.revise.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rishabh.revise.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

import com.rishabh.revise.dto.StdRequest;
import com.rishabh.revise.dto.StdResponse;
import com.rishabh.revise.entity.Student;

@Service
@RequiredArgsConstructor

public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public StdResponse createStudent(StdRequest stdRequest) {
        Student student = Student.builder()
                .name(stdRequest.getName())
                .email(stdRequest.getEmail())
                .password(stdRequest.getPassword())
                .build();

        studentRepository.save(student);
        return StdResponse.builder()
                .name(student.getName())
                .mail(student.getEmail())
                .build();
}

    @Override
    public List<StdResponse> getAllStudents() {

    }

    @Override
    public StdResponse getStudentById(Long id) {

    }

    @Override
    public StdResponse updateStudent(Long id, StdRequest request) {

    }

    @Override
    public void deleteStudent(Long id) {

    }
}