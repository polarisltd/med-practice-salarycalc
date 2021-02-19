package com.chen.salarycalc.entities.salaries;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "bslgc")
public class CommissionCalculator extends SalaryCalculator {

    private final String type = "commission";
    private double commission;

    @Override
    public double calculateSalary(List<Salary> salaries) {
        final int MONTHS_IN_YEAR = 12;
        int sum = 0;
        for (Salary salary : salaries){
            sum += salary.getSalary();
        }
        double salary = sum / MONTHS_IN_YEAR;
        salary *= commission;

        return salary;
    }
}
