package lv.polarisit.salarycalc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lv.polarisit.salarycalc.controllers.SalaryTypeEnum;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class SalaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal VsaoiDN;
    private BigDecimal VsaoiDD;
    private BigDecimal RiskaNodeva;
    private BigDecimal TotalTax;
    private BigDecimal Payout;
    private BigDecimal TotalDD;
    private BigDecimal KoefBrutoAlgaNetoAlga;
    private String name;
    private BigDecimal bruto;
    private BigDecimal neaplMin;
    private SalaryTypeEnum type;
    private String period;
    private BigDecimal hourlyRate;
    private BigDecimal hoursWorked;
    private int daysWorked;
    private BigDecimal dailyRate;

    // Getters and Setters
}