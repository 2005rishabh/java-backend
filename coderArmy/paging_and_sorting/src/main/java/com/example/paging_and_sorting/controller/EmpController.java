package com.example.paging_and_sorting.controller;

import static org.springframework.data.domain.Sort.by;

import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.paging_and_sorting.model.Employee;
import com.example.paging_and_sorting.service.EmpService;

@RestController
@RequestMapping("/employees")
public class EmpController {

    private final EmpService empService;

    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    @GetMapping("/list")
    public List<Employee> getEmployees(
            @RequestParam(required = false, defaultValue = "1") int pageNo,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            @RequestParam(required = false, defaultValue = "id") String sortBy,
            @RequestParam(required = false, defaultValue = "ASC") String sortDirection,
            @RequestParam(required = false) String search) {

        Sort sort = null;
        if (sortDirection.equalsIgnoreCase("ASC")) {
            sort = Sort.by(sortBy).ascending();
        } else {
            sort = Sort.by(sortBy).descending();
        }
        int pageIndex = (pageNo < 1) ? 0 : pageNo - 1;
        return empService.fetchEmployees(PageRequest.of(pageIndex, pageSize, sort), search);
    }
}