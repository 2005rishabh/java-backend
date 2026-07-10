package com.example.paging_and_sorting.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.paging_and_sorting.model.Employee;
import com.example.paging_and_sorting.repository.EmpRepository;

@Service
public class EmpService {

    private final EmpRepository empRepository;

    public EmpService(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }

    public List<Employee> fetchEmployees(Pageable pageable, String search) {
        if (search == null) {
            return empRepository.findAll(pageable).getContent();
        }
        return empRepository.findByName(search, pageable).getContent();
    }
}