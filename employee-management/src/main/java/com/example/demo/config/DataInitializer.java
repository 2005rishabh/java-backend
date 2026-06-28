package com.example.demo.config;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) {
        if (employeeRepository.count() == 0) {
            List<Employee> employees = List.of(
                    new Employee(null, "Alice", "Johnson", "alice.johnson@acme.com", "Engineering"),
                    new Employee(null, "Bob", "Smith", "bob.smith@acme.com", "Sales"),
                    new Employee(null, "Carol", "Davis", "carol.davis@acme.com", "HR")
            );
            employeeRepository.saveAll(employees);
        }
    }
}
