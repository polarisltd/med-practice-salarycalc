package lv.polarisit.salarycalc.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExpressionRequest {
    private String name;
    private String period;
    private String expr;
    private double pct; // New field for percentage
}
