package com.apps.quantitymeasurement;

import java.util.Objects;

enum LengthUnit {
    FEET(12),
    INCH(1),
    YARD(36),
    CENTIMETER(0.393701);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }
}

public class Length {

    private final double value;
    private final LengthUnit unit;
    private static final double EPSILON = 1e-6;

    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Length other = (Length) obj;
        return Math.abs(this.toBaseInch() - other.toBaseInch()) <= EPSILON;
    }

    @Override
    public int hashCode() {
        long normalized = Math.round(toBaseInch() / EPSILON);
        return Objects.hash(normalized);
    }

    private double toBaseInch() {
        return value * unit.getConversionFactor();
    }


    public  double demonstrateConversion(Length length) {
        if (length == null) throw new IllegalArgumentException("length must not be null");
        System.out.println("Converting " + length + " to inches: " + length.toBaseInch() + " inches");
        return  length.toBaseInch();
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }

    public static double demonstrateAddition(Length L1,Length L2){
      Double add= L1.toBaseInch() + L2.toBaseInch();

        System.out.println((add / L1.getUnit().getConversionFactor()));

        System.out.println(L1.getUnit());


        return ((add / L1.getUnit().getConversionFactor()));
    }

    }





