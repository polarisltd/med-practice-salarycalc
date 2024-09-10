package lv.polarisit.salarycalc.controllers;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@EqualsAndHashCode
public class OutputPayload extends InputPayload{
    private BigDecimal vsaoiDN;
    private BigDecimal vsaoiDD;
    private BigDecimal IeIeN;
    private BigDecimal riskaNodeva;
    private BigDecimal totalTax;
    private BigDecimal payout;
    private BigDecimal totalDD;
    private BigDecimal koefBrutoAlgaNetoAlga;
    private BigDecimal bruto;
    private String comment;

    // Getters and Setters
}