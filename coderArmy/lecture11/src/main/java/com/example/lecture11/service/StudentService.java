package com.example.lecture11.service;

import java.util.List;

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
        reqStudent.setDeleted(false);
        Student createdStudent = studentRepository.save(reqStudent);
        return createdStudent;
    }

    public List<Student> getStudent() {
        List<Student> stdLists = studentRepository.findAll();
        return stdLists;
    }

    public Student getStudentById(Long id) {
        Student createdStudent = studentRepository.findById(id).
        orElseThrow(() -> new RuntimeException(
            "Not found by id " + id
        ));
        return createdStudent;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Long id, Student studentDetails) {

        Student existingStudent = studentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found by id " + id));
        existingStudent.setId(studentDetails.getId());
        existingStudent.setName(studentDetails.getName());
        existingStudent.setEmail(studentDetails.getEmail());
        existingStudent.setAge(studentDetails.getAge());
        existingStudent.setRollNumber(studentDetails.getRollNumber());
        existingStudent.setSubject(studentDetails.getSubject());

        return studentRepository.save(existingStudent);
    }


    public Student softDelete(Long id) {

        Student existingStudent = studentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found by id " + id));

        existingStudent.setDeleted(true);
        
        return studentRepository.save(existingStudent);
    }
}
