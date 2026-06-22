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
                .email(student.getEmail())
                .build();
    }

    @Override
    public List<StdResponse> getAllStudents() {
        List<Student> list = studentRepository.findAll();

        return list.stream()
                .map(
                        student -> StdResponse.builder()
                                .name(student.getName())
                                .email(student.getEmail())
                                .build())
                .toList();
    }

    @Override
    public StdResponse getStudentById(Long id) {
        Student std = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No student find by id : " + id));

        return StdResponse.builder()
                .name(std.getName())
                .email(std.getEmail())
                .build();
    }

    @Override
    public StdResponse updateStudent(Long id, StdRequest request) {
        Student std = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No student find by id : " + id));

        std.setName(request.getName());
        std.setEmail(request.getEmail());
        std.setPassword(request.getPassword());

        Student savedEntity = studentRepository.save(std);

        return StdResponse.builder()
                .name(savedEntity.getName())
                .email(savedEntity.getEmail())
                .build();
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}