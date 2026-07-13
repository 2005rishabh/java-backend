package com.rishabh.dto.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rishabh.dto.dtos.ReqDto;
import com.rishabh.dto.dtos.ResDto;
import com.rishabh.dto.entity.Student;
import com.rishabh.dto.repository.StudentRepository;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public ResDto createStudent(ReqDto reqStudent) {
        Student student = maptoEntity(reqStudent);

        Student savedEntity = studentRepository.save(student);

        return mapToDto(savedEntity);
    }

    public List<ResDto> getStudent() {
        List<Student> stdLists = studentRepository.findByDeletedIsFalse();
        List<ResDto> response = new ArrayList<>();

        for (Student student : stdLists) {
            response.add(mapToDto(student));
        }

        return response;
    }

    public ResDto getStudentById(Long id) {
        Student createdStudent = studentRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new RuntimeException("Not found by id " + id));
        return mapToDto(createdStudent);
    }

    public ResDto updateStudent(Long id, ReqDto studentDetails) {

        Student existingStudent = studentRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new RuntimeException("Not found by id " + id));
        existingStudent.setName(studentDetails.getName());
        existingStudent.setEmail(studentDetails.getEmail());
        existingStudent.setAge(studentDetails.getAge());
        existingStudent.setRollNumber(studentDetails.getRollNumber());
        existingStudent.setSubject(studentDetails.getSubject());
        existingStudent.setDeleted(false);
        existingStudent.setUpdatedAt(LocalDateTime.now());

        return mapToDto(studentRepository.save(existingStudent));
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public ResDto softDelete(Long id) {

        Student existingStudent = studentRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new RuntimeException("Not found by id " + id));

        existingStudent.setDeleted(true);
        existingStudent.setUpdatedAt(LocalDateTime.now());

        return mapToDto(studentRepository.save(existingStudent));
    }

    // HELPER FUNCTION I WILL CREATE SEPERATE CLASS OF IT IN FUTURE

    private Student maptoEntity(ReqDto req) {
        Student std = new Student();
        std.setName(req.getName());
        std.setAge(req.getAge());
        std.setEmail(req.getEmail());
        std.setRollNumber(req.getRollNumber());
        std.setSubject(req.getSubject());
        std.setDeleted(false);
        std.setCreatedAt(LocalDateTime.now());
        std.setUpdatedAt(LocalDateTime.now());

        return std;
    }

    private ResDto mapToDto(Student req) {
        ResDto std = new ResDto();

        std.setId(req.getId());
        std.setName(req.getName());
        std.setAge(req.getAge());
        std.setEmail(req.getEmail());
        std.setRollNumber(req.getRollNumber());
        std.setSubject(req.getSubject());
        std.setCreatedAt(req.getCreatedAt());
        std.setUpdatedAt(req.getUpdatedAt());

        std.setMessage("Saved successfully");
        return std;
    }
}
