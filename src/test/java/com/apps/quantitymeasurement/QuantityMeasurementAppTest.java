package com.apps.quantitymeasurement;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    @DisplayName("Feet equality: 1 ft == 1 ft")
    void testFeetEquality() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);
        boolean result = QuantityMeasurementApp.demonstrateLengthEquality(l1, l2);
        assertTrue(result);
    }

    @Test
    @DisplayName("Inches equality: 12 in == 12 in")
    void testInchesEquality() {
        Length inches1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length inches2 = new Length(12.0, Length.LengthUnit.INCHES);
        boolean result = QuantityMeasurementApp.demonstrateLengthEquality(inches1, inches2);
        assertTrue(result);
    }

    @Test
    @DisplayName("Feet ↔ Inches comparison: 1 ft == 12 in")
    void testFeetInchesComparison() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);
        boolean result = QuantityMeasurementApp.demonstrateLengthEquality(feet, inches);
        assertTrue(result);
    }

    @Test
    @DisplayName("Feet inequality: 1 ft != 2 ft")
    void testFeetInequality() {
        Length a = new Length(1.0, Length.LengthUnit.FEET);
        Length b = new Length(2.0, Length.LengthUnit.FEET);
        boolean result = QuantityMeasurementApp.demonstrateLengthEquality(a, b);
        assertFalse(result);
    }

    @Test
    @DisplayName("Inches inequality: 10 in != 12 in")
    void testInchesInequality() {
        Length a = new Length(10.0, Length.LengthUnit.INCHES);
        Length b = new Length(12.0, Length.LengthUnit.INCHES);
        boolean result = QuantityMeasurementApp.demonstrateLengthEquality(a, b);
        assertFalse(result);
    }

    @Test
    @DisplayName("Cross-unit inequality: 11 in != 1 ft")
    void testCrossUnitInequality() {
        Length a = new Length(11.0, Length.LengthUnit.INCHES);
        Length b = new Length(1.0, Length.LengthUnit.FEET);
        boolean result = QuantityMeasurementApp.demonstrateLengthEquality(a, b);
        assertFalse(result);
    }

    @Test
    @DisplayName("Multiple feet comparison: 2 ft == 24 in, 3 ft != 24 in")
    void testMultipleFeetComparison() {
        Length twoFeet = new Length(2.0, Length.LengthUnit.FEET);
        Length twentyFourInches = new Length(24.0, Length.LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(twoFeet, twentyFourInches));

        Length threeFeet = new Length(3.0, Length.LengthUnit.FEET);
        assertFalse(QuantityMeasurementApp.demonstrateLengthEquality(threeFeet, twentyFourInches));
    }
}
