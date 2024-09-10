package lv.polarisit.salarycalc.controllers;

import jakarta.validation.Valid;
import lv.polarisit.salarycalc.entities.salaries.SalaryHelper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lv.polarisit.salarycalc.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/salary")
@Tag(name = "Salary", description = "Salary management APIs")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    @PostMapping(value = "/calc")
    @Operation(summary = "Calculate salary", description = "Calculates the salary based on provided parameters")
    public ResponseEntity<OutputPayload> calculateSalary(@Valid @RequestBody InputPayload input) {
        BigDecimal bruto;
        if (input.getType() == SalaryTypeEnum.HOURLY) {
            bruto = input.getHourlyRate().multiply(input.getHoursWorked());
        } else {
            bruto = input.getDailyRate().multiply(BigDecimal.valueOf(input.getDaysWorked()));
        }

        OutputPayload output = SalaryHelper.salaryCalculator(bruto, input.getNodoGramatina(), input.getNeaplMin());
        output.setBruto(bruto);
        output.setName(input.getName())  ;
        output.setNeaplMin(input.getNeaplMin());
        output.setType(input.getType());
        output.setPeriod(input.getPeriod());
        if (input.getType() == SalaryTypeEnum.HOURLY) {
            output.setHourlyRate(input.getHourlyRate());
            output.setHoursWorked(input.getHoursWorked());
        } else {
            output.setDaysWorked(input.getDaysWorked());
            output.setDailyRate(input.getDailyRate());
        }
        salaryService.saveSalary(output);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }
}