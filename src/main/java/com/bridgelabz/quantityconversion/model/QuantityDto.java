package com.bridgelabz.quantityconversion.model;

public class QuantityDto {
    private final double VALUE;
    private final Unit UNIT;

    public QuantityDto(double VALUE, Unit UNIT) {
        this.VALUE = VALUE;
        this.UNIT = UNIT;
    }

    public double getVALUE() {
        return VALUE;
    }

    public Unit getUNIT() {
        return UNIT;
    }
}
