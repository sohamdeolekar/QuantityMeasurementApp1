package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuantityMeasurementAppTest {

    @Test
    void testFeetEquality_SameValue() {
        QuantityMeasurementApp.Feet feet1 =
                new QuantityMeasurementApp.Feet(5.0);
        QuantityMeasurementApp.Feet feet2 =
                new QuantityMeasurementApp.Feet(5.0);

        assertTrue(feet1.equals(feet2));
    }

    @Test
    void testFeetEquality_DifferentValues() {
        QuantityMeasurementApp.Feet feet1 =
                new QuantityMeasurementApp.Feet(5.0);
        QuantityMeasurementApp.Feet feet2 =
                new QuantityMeasurementApp.Feet(6.0);

        assertFalse(feet1.equals(feet2));
    }

    @Test
    void testFeetEquality_SameReference() {
        QuantityMeasurementApp.Feet feet =
                new QuantityMeasurementApp.Feet(5.0);

        assertTrue(feet.equals(feet));
    }

    @Test
    void testFeetEquality_NullComparison() {
        QuantityMeasurementApp.Feet feet =
                new QuantityMeasurementApp.Feet(5.0);

        assertFalse(feet.equals(null));
    }

    @Test
    void testFeetEquality_DifferentObject() {
        QuantityMeasurementApp.Feet feet =
                new QuantityMeasurementApp.Feet(5.0);

        assertFalse(feet.equals("5.0"));
    }

    void testInchesEquality_SameValue() {
        QuantityMeasurementApp.Inches inch1 =
                new QuantityMeasurementApp.Inches(5.0);
        QuantityMeasurementApp.Inches inch2 =
                new QuantityMeasurementApp.Inches(5.0);

        assertTrue(inch1.equals(inch2));
    }

    @Test
    void testInchesEquality_DifferentValues() {
        QuantityMeasurementApp.Inches inch1 =
                new QuantityMeasurementApp.Inches(5.0);
        QuantityMeasurementApp.Inches inch2 =
                new QuantityMeasurementApp.Inches(6.0);

        assertFalse(inch1.equals(inch2));
    }

    @Test
    void testInchesEquality_SameReference() {
        QuantityMeasurementApp.Inches inch =
                new QuantityMeasurementApp.Inches(5.0);

        assertTrue(inch.equals(inch));
    }

    @Test
    void testInchesEquality_NullComparison() {
        QuantityMeasurementApp.Inches inch =
                new QuantityMeasurementApp.Inches(5.0);

        assertFalse(inch.equals(null));
    }

    @Test
    void testInchesEquality_DifferentObject() {
        QuantityMeasurementApp.Inches inch =
                new QuantityMeasurementApp.Inches(5.0);

        assertFalse(inch.equals("5.0"));
    }

}
