package in.rishabh.filterDemo.service;

import org.springframework.stereotype.Service;

import in.rishabh.filterDemo.DTO.Student;

@Service
public class StudentService {
    public void createStudent(Student student) {
        System.out.println("Student created successfully");
        System.out.println(student.getName());
        System.out.println(student.getEmail());
    }
}
