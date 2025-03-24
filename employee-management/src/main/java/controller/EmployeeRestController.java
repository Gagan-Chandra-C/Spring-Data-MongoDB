package com.example.employeemanagement.controller;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

@Autowired
private EmployeeRepository employeeRepository;

// Save Employee (Create)
@PostMapping("/save")
public Employee saveEmployee(@RequestBody Employee employee) {
return employeeRepository.save(employee);
}

// Get all Employees (Read)
@GetMapping("/displayAll")
public List<Employee> getAllEmployees() {
return employeeRepository.findAll();
}

// Get Employee by ID (Read)
@GetMapping("/display/{id}")
public Optional<Employee> getEmployeeById(@PathVariable String id) {
return employeeRepository.findById(id);
}
}
