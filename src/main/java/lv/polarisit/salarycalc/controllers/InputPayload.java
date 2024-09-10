package lv.polarisit.salarycalc.controllers;

import jakarta.validation.constraints.Pattern;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Setter
@Getter
@EqualsAndHashCode
public class InputPayload {
    @Schema(description = "Name of the employee", example = "Santa")
    private String name;

    @Schema(description = "Period yyyy-mm", example = "2024-08")
    @Pattern(regexp = "^\\d{4}-\\d{2}$", message = "Period must be in the format yyyy-mm")
    private String period;

    @Schema(description = "Ir nodoklu gramatina (pamatdarbs)", example = "false")
    private Boolean nodoGramatina;

    @Schema(description = "Type of salary calculation (Hourly or Daily)", example = "HOURLY")
    private SalaryTypeEnum type;

    @Schema(description = "Number of hours worked", example = "40.00")
    private BigDecimal hoursWorked;

    @Schema(description = "Number of days worked", example = "5")
    private int daysWorked;

    @Schema(description = "Hourly rate", example = "15.50")
    private BigDecimal hourlyRate;

    @Schema(description = "Daily rate", example = "120.00")
    private BigDecimal dailyRate;

    @Schema(description = "Non-taxable minimum", example = "200.00")
    private BigDecimal neaplMin;
}
