package lv.polarisit.salarycalc.entities.salaries;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "bslgc")
public class HourlyCalculator extends SalaryCalculator {

    private final String type = "hourly";
    private int rate;
    private int hours;

    @Override
    public double calculateSalary(List<Salary> salaries) {
        return rate * hours;
    }
}
