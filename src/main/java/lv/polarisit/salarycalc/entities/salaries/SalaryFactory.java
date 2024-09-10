package lv.polarisit.salarycalc.entities.salaries;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SalaryFactory {

    private final List<SalaryCalculator> salaries;

    private static final Map<String, SalaryCalculator> salariesByType = new HashMap<>();

    public SalaryFactory(List<SalaryCalculator> salaries) {
        this.salaries = salaries;
    }

    @PostConstruct
    private void init() {
        salaries.forEach(salary ->  salariesByType.put(salary.getType(), salary));
    }

    public static SalaryCalculator getSalaryCalculator(String type) throws IOException {
        if (!salariesByType.containsKey(type)) {
            throw new IOException(String.format("Failed to find type %s", type));
        }

        return salariesByType.get(type);
    }
}
