package com.chen.salarycalc.repositories;

import com.chen.salarycalc.entities.employees.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
