package com.rishabh.dto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rishabh.dto.entity.Student;
import com.rishabh.dto.repository.StudentRepository;

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
        List<Student> stdLists = studentRepository.findByDeletedIsFalse();
        return stdLists;
    }

    public Student getStudentById(Long id) {
        Student createdStudent = studentRepository.findByIdAndDeletedIsFalse(id).
        orElseThrow(() -> new RuntimeException(
            "Not found by id " + id
        ));
        return createdStudent;
    }
    
    public Student updateStudent(Long id, Student studentDetails) {

        Student existingStudent = studentRepository.findByIdAndDeletedIsFalse(id)
            .orElseThrow(() -> new RuntimeException("Not found by id " + id));
        existingStudent.setId(studentDetails.getId());
        existingStudent.setName(studentDetails.getName());
        existingStudent.setEmail(studentDetails.getEmail());
        existingStudent.setAge(studentDetails.getAge());
        existingStudent.setRollNumber(studentDetails.getRollNumber());
        existingStudent.setSubject(studentDetails.getSubject());
        existingStudent.setDeleted(false);

        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student softDelete(Long id) {

        Student existingStudent = studentRepository.findByIdAndDeletedIsFalse(id)
            .orElseThrow(() -> new RuntimeException("Not found by id " + id));

        existingStudent.setDeleted(true);
        
        return studentRepository.save(existingStudent);
    }
}
