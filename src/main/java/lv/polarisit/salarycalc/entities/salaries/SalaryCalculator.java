package lv.polarisit.salarycalc.entities.salaries;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class SalaryCalculator {

    @Getter
    private String type;
    public abstract double calculateSalary(List<Salary> salaries);
}
