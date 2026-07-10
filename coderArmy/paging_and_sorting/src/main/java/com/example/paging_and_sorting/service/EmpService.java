package com.example.paging_and_sorting.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.paging_and_sorting.model.Employee;
import com.example.paging_and_sorting.repository.EmpRepository;

@Service // <-- This is critical!
public class EmpService {

    private final EmpRepository empRepository;

    // Spring will inject the JPA repository interface implementation automatically
    public EmpService(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }

    public List<Employee> fetchEmployees(Pageable pageable) {
        return empRepository.findAll(pageable).getContent();
    }
}