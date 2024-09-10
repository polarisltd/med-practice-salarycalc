package lv.polarisit.salarycalc.services;

import lv.polarisit.salarycalc.dal.EmployeeDAL;
import lv.polarisit.salarycalc.entities.employees.Employee;
import lv.polarisit.salarycalc.entities.salaries.SalaryCalculator;
import lv.polarisit.salarycalc.entities.salaries.SalaryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAL employeeDAL;

    public List<Employee> getAllEmployees(){ return employeeDAL.getEmployees(); }

    public List<Map<String, String>> getAllEmployeesSalaries() throws IOException {
        List<Map<String, String>> output = new ArrayList<>();
        List<Employee> employees = employeeDAL.getEmployees();
        for (Employee employee : employees) {
            Map<String, String> employeeOutput = new HashMap<>();
            employeeOutput.put("emp_no", String.valueOf(employee.getId()));
            employeeOutput.put("first_name", employee.getFirstName());
            employeeOutput.put("last_name", employee.getLastName());

            SalaryCalculator salaryCalculator = SalaryFactory.getSalaryCalculator(employee.getType());
            double salary = salaryCalculator.calculateSalary(employee.getSalaries());
            employeeOutput.put("salary", String.valueOf(salary));

            output.add(employeeOutput);
        }
        return output;
    }
}
