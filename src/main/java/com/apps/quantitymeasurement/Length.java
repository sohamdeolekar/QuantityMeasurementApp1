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

    public static Length demonstrateAddition(Length l1, Length l2) {
        if (l1 == null || l2 == null) {
            throw new IllegalArgumentException("Both lengths must be non-null");
        }

        // Convert both lengths to the base unit (inches) and add
        double sumInInches = l1.toBaseInch() + l2.toBaseInch();

        // Convert the sum (in inches) back into l1's unit so the result is expressed in l1.getUnit()
        double resultValueInL1Unit = sumInInches / l1.getUnit().getConversionFactor();

        // Create a Length representing the sum in l1's unit
        Length result = new Length(resultValueInL1Unit, l1.getUnit());

        // Log a clear, user-friendly message
        System.out.println("Adding " + l1 + " and " + l2 + " = " + result.getValue() + " " + result.getUnit());

        return result;
    }

    }
