package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
}
