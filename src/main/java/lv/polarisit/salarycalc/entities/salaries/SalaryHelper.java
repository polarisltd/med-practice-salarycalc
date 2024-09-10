package lv.polarisit.salarycalc.entities.salaries;

        import java.math.BigDecimal;
        import java.math.RoundingMode;
        import lv.polarisit.salarycalc.controllers.OutputPayload;



public class SalaryHelper {

        /*

         This method calculates the salary of an employee.

        VsaoiDN = bruto * 0.105
        IeIeN = round(bruto – neaplMin – vsaoiDN) * 0.2 ,2 )
        VsaoiDD = round(bruto * 0.2359, 2)
        RiskaNodeva = 0.36
        TotalTax = vsaoiDD + ieieN + vsaoiDN + riskaNodeva
        Payout = bruto – vsaoiDN – IeIeN
        TotalDD =   TotalTax + PayOut
        KoefBrutoAlgaNetoAlga = round( bruto / Payout, 2)

        */


    public static BigDecimal round(BigDecimal value, int places) {
        if (places < 0) throw new IllegalArgumentException("Decimal places must be non-negative");
        return value.setScale(places, RoundingMode.HALF_UP);
    }

    public static OutputPayload salaryCalculator(BigDecimal bruto, Boolean isNodokluGramatina, BigDecimal neaplMin) {
        OutputPayload output = new OutputPayload();

        BigDecimal VsaoiDN = bruto.multiply(BigDecimal.valueOf(0.105));
        BigDecimal IeIeN = calculateIin(isNodokluGramatina,
                bruto,
                neaplMin,
                VsaoiDN);
        BigDecimal VsaoiDD = round(
                bruto.multiply(BigDecimal.valueOf(0.2359)),
                2
        );
        BigDecimal RiskaNodeva = BigDecimal.valueOf(0.36);
        BigDecimal TotalTax = VsaoiDD
                .add(IeIeN)
                .add(VsaoiDN)
                .add(RiskaNodeva);
        BigDecimal Payout = bruto
                .subtract(VsaoiDN)
                .subtract(IeIeN);
        BigDecimal TotalDD = TotalTax
                .add(Payout);
        BigDecimal KoefBrutoAlgaNetoAlga = bruto
                .divide(Payout, 2, RoundingMode.HALF_UP);

        output.setVsaoiDN(VsaoiDN);
        output.setVsaoiDD(VsaoiDD);
        output.setIeIeN(IeIeN);
        output.setRiskaNodeva(RiskaNodeva);
        output.setTotalTax(TotalTax);
        output.setPayout(Payout);
        output.setTotalDD(TotalDD);
        output.setKoefBrutoAlgaNetoAlga(KoefBrutoAlgaNetoAlga);
        output.setNodoGramatina(isNodokluGramatina);
        output.setComment(
                "TotalTax = vsaoiDD + ieieN + vsaoiDN + riskaNodeva \n" +
                        "IeIeN = ROUND (bruto – neaplMin – vsaoiDN) * 0.2 // Ar GR \n" +
                        "IeIeN = ROUND  (bruto*0.23 – vsaoiDN * 0.2)  // Bez GR\n" +
                        "Payout = bruto – vsaoiDN – IeIeN \n" +
                        "TotalDD =   TotalTax + PayOut \n" +
                        "KoefBrutoAlgaNetoAlga = bruto / Payout \n" +
                        "neaplMinimums: https://latkredits.lv/lv/blog/neapliekamais-minimums/ "
        );

        return output;
    }

    private static BigDecimal calculateIin(Boolean isNodokluGramatina,
                            BigDecimal bruto,
                            BigDecimal neaplMin,
                            BigDecimal VsaoiDN) {
        {
            // IeIeN = ROUND (bruto – neaplMin – vsaoiDN) * 0.2 // Ar Gr
            // IeIeN = ROUND  (bruto*0.23 – vsaoiDN * 0.2)  // BEZ gr

            if (isNodokluGramatina) {

                return round(
                        bruto.subtract(neaplMin)
                                .subtract(VsaoiDN)
                                .multiply(BigDecimal.valueOf(0.2)),
                        2
                );
            } else {
                return round(
                        bruto.multiply(BigDecimal.valueOf(0.23))
                                .subtract(VsaoiDN.multiply(BigDecimal.valueOf(0.2))),
                        2
                );
            }
        }

    }
}
