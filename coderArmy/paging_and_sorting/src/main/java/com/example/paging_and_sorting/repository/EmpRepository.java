package com.example.paging_and_sorting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.paging_and_sorting.model.Employee;

@Repository

public interface EmpRepository extends JpaRepository<Employee, Long> {

}
