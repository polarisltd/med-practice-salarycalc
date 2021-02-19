package com.chen.salarycalc.dal;

import com.chen.salarycalc.entities.employees.Employee;
import com.chen.salarycalc.repositories.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class EmployeeDAL {
    final EmployeeRepository jpaRepository;

    @Autowired
    public EmployeeDAL(EmployeeRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    /**
     * Gets employee list from DB; log will be present either way
     * @return All Employee records
     */
    public List<Employee> getEmployees() {
        List<Employee> employees = Collections.emptyList();
        try {
            employees = jpaRepository.findAll();
            log.info("Successfully got {} employees", employees.size());
        } catch (Exception e) {
            log.error("Failed to get employees", e);
        }

        return employees;
    }
}
