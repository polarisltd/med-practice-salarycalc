package com.chen.salarycalc.entities.salaries;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalariedCalculator extends SalaryCalculator {

    @Getter
    private final String type = "salary";

    @Override
    public double calculateSalary(List<Salary> salaries) {
        final int MONTHS_IN_YEAR = 12;
        int sum = 0;
        for (Salary salary : salaries){
            sum += salary.getSalary();
        }
        double salary = sum / MONTHS_IN_YEAR;
        return salary;
    }
}
