package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
@Tag(name = "Employee Management", description = "Operations for managing employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Operation(summary = "Get all employees", description = "Retrieve all employees")
    @ApiResponse(responseCode = "200", description = "Employees retrieved successfully")
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @Operation(summary = "Get employee by ID", description = "Retrieve an employee by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Employee retrieved successfully"),
        @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @Operation(summary = "Create employee", description = "Create a new employee")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Employee created successfully"),
        @ApiResponse(responseCode = "400", description = "Validation failed")
    })
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
    }

    @Operation(summary = "Update employee", description = "Update an existing employee")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Employee updated successfully"),
        @ApiResponse(responseCode = "404", description = "Employee not found"),
        @ApiResponse(responseCode = "400", description = "Validation failed")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
    }

    @Operation(summary = "Delete employee", description = "Delete an employee by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Employee deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
