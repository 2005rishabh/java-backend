package com.rishabh.revise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rishabh.revise.entity.Student;

@Repository

public interface StudentRepository extends JpaRepository<Student, Long> {

}
