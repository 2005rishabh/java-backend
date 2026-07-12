package com.rishabh.springmvc.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.rishabh.springmvc.entity.Student;

@Repository

public class StdRepository {
    private Map<Long, Student> map;

    public StdRepository() {
        map = new HashMap<>();
    }

    public Student save(Student student) {
        map.put(student.getId(), student);
        return student;
    }
    
    public Student findByID(Long id) {
        return map.get(id);
    }

    public List<Student> findAll() {
        return new ArrayList<>(map.values());
    }

}
