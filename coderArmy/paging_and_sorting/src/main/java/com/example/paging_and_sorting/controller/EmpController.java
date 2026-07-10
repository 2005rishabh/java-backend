package com.example.paging_and_sorting.controller;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.paging_and_sorting.model.Employee;
import com.example.paging_and_sorting.service.EmpService;

@RestController
@RequestMapping("/employees")
public class EmpController {

    private final EmpService empService;

    // Spring will automatically inject the EmpService bean here
    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    @GetMapping("/list")
    public List<Employee> getEmployees(@RequestBody int pageNo, 
                                    @RequestBody int pageSize
    ) {
        return empService.fetchEmployees(PageRequest.of(pageNo, pageSize));
    }
}