package com.apps.quantitymeasurement;

import java.util.Objects;

/**
 * Immutable Length value object with base unit = INCHES.
 * Supports FEET and INCHES conversions, epsilon-aware equality,
 * and user-friendly helpers for interactive apps.
 */
public final class Length implements Comparable<Length> {

    // ===== Configuration =====
    /** Epsilon used for equality to handle floating point rounding. */
    public static final double EPSILON = 1e-9;

    // ===== State =====
    private final double value;
    private final LengthUnit unit;

    // ===== Units =====
    public enum LengthUnit {
        // Base unit is INCHES. Each factor is "how many inches per 1 unit".
        FEET(12.0),
        INCHES(1.0);

        private final double inchesPerUnit;

        LengthUnit(double inchesPerUnit) {
            this.inchesPerUnit = inchesPerUnit;
        }

        /** Returns the number of inches in one unit of this LengthUnit. */
        public double getConversionFactor() {
            return inchesPerUnit;
        }
    }

    // ===== Constructors / Factories =====
    public Length(double value, LengthUnit unit) {
        validate(value, unit);
        this.value = value;
        this.unit = unit;
    }

    /** Factory helpers (readability) */
    public static Length ofFeet(double feet)   { return new Length(feet, LengthUnit.FEET); }
    public static Length ofInches(double inch) { return new Length(inch, LengthUnit.INCHES); }

    private static void validate(double value, LengthUnit unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Value must be a finite number");
        }
        if (value < 0) { // change this rule if negatives should be allowed
            throw new IllegalArgumentException("Value cannot be negative");
        }
    }

    // ===== Accessors =====
    public double getValue() { return value; }
    public LengthUnit getUnit() { return unit; }

    // ===== Conversions =====
    /** Convert this length to the base unit (inches). */
    public double toBaseInches() {
        return value * unit.getConversionFactor();
    }

    /** Return a new Length converted to the requested unit. */
    public Length to(LengthUnit target) {
        Objects.requireNonNull(target, "Target unit cannot be null");
        double inches = toBaseInches();
        double targetValue = inches / target.getConversionFactor();
        return new Length(targetValue, target);
    }

    // ===== Comparisons =====
    /**
     * Compares equality using epsilon tolerance in base unit (inches).
     * Two values are considered equal if |a - b| <= EPSILON.
     */
    public boolean compare(Length that) {
        if (that == null) return false;
        double diff = Math.abs(this.toBaseInches() - that.toBaseInches());
        return diff <= EPSILON;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Length)) return false;
        Length that = (Length) obj;
        return compare(that);
    }

    @Override
    public int hashCode() {
        // Normalize to base inches and round to epsilon to keep equals/hashCode consistent
        long bucket = Math.round(this.toBaseInches() / EPSILON);
        return Long.hashCode(bucket);
    }

    /**
     * Natural ordering based on base inches.
     * Returns negative, zero, or positive like Double.compare.
     */
    @Override
    public int compareTo(Length o) {
        if (o == null) throw new NullPointerException("Cannot compare with null");
        return Double.compare(this.toBaseInches(), o.toBaseInches());
    }

    @Override
    public String toString() {
        return String.format("%.4f %s", value, unit);
    }
}