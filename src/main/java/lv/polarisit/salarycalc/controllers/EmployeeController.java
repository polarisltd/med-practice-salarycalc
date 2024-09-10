package lv.polarisit.salarycalc.controllers;

import lv.polarisit.salarycalc.entities.employees.Employee;
import lv.polarisit.salarycalc.services.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("/api/salary")
@Tag(name = "Salary", description = "Salary management APIs")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/all")
    @Operation(summary = "Calculate salary", description = "Calculates the salary based on provided parameters")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping(value = "/salaries")
    @Operation(summary = "Calculate salary", description = "Calculates the salary based on provided parameters")
    public ResponseEntity<List<Map<String, String>>> getAllEmployeesSalaries() throws IOException {
        List<Map<String, String>> output = employeeService.getAllEmployeesSalaries();
        return new ResponseEntity<>(output, HttpStatus.OK);
    }
}
