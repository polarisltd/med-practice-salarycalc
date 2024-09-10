package lv.polarisit.salarycalc.repositories;

import lv.polarisit.salarycalc.entities.employees.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
