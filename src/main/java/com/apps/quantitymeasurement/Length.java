
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

    @Override
    public String toString() {
        return value + " " + unit;
    }
}
