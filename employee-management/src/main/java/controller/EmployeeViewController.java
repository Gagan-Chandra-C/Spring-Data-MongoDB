package com.example.employeemanagement.controller;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeViewController {

@Autowired
private EmployeeRepository employeeRepository;

@GetMapping("/")
public String showForm(Model model) {
model.addAttribute("employee", new Employee());
return "index";
}

@PostMapping("/saveEmployee")
public String saveEmployee(
@RequestParam String id,
@RequestParam String name,
@RequestParam String email,
@RequestParam String location) {

Employee employee = new Employee(id, name, email, location);
employeeRepository.save(employee);
return "redirect:/employees/displayAll";
}

@GetMapping("/employees/displayAll")
public String listEmployees(Model model) {
model.addAttribute("employees", employeeRepository.findAll());
return "employees";
}
}