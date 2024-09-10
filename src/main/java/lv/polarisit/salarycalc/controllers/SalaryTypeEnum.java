package lv.polarisit.salarycalc.controllers;

public enum SalaryTypeEnum {
    HOURLY("HOURLY"),
    DAILY("DAILY");

    private final String value;

    SalaryTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
