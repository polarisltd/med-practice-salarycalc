package com.chen.salarycalc.controllers;

import com.chen.salarycalc.entities.employees.Employee;
import com.chen.salarycalc.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping(value = "/salaries")
    public ResponseEntity<List<Map<String, String>>> getAllEmployeesSalaries() throws IOException {
        List<Map<String, String>> output = employeeService.getAllEmployeesSalaries();
        return new ResponseEntity<>(output, HttpStatus.OK);
    }
}
