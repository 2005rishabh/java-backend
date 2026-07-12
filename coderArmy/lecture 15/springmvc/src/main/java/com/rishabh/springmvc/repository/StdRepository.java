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
    private long nextId;

    public StdRepository() {
        map = new HashMap<>();
        nextId = 1L;
    }

    public Student save(Student student) {
        if (student.getId() == null) {
            student.setId(nextId++);
        }
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
