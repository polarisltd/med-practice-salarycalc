package lv.polarisit.salarycalc.controllers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpressionResponse {
    private String name;
    private String period;
    private double result;
    private double pct; // New field for percentage
    private double brutoPct; // New field for result * pct
}