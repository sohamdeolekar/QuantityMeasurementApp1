// java
package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void feetEqualsYard() {
        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(0.33333333, LengthUnit.YARD);
        assertTrue(l1.equals(l2), "1 foot should equal approximately 0.33333333 yard");
    }

    @Test
    public void centimeterEqualsInch() {
        Length l3 = new Length(1.0, LengthUnit.CENTIMETER);
        Length l4 = new Length(0.393701, LengthUnit.INCH);
        assertTrue(l3.equals(l4), "1 cm should equal approximately 0.393701 inch");
    }

    @Test
    public void yardEqualsInch() {
        Length l5 = new Length(1, LengthUnit.YARD);
        Length l6 = new Length(36, LengthUnit.INCH);
        assertTrue(l5.equals(l6), "1 yard should equal 36 inches");
    }

    @Test
    public void differentValuesAreNotEqual() {
        Length a = new Length(2, LengthUnit.FEET);
        Length b = new Length(3, LengthUnit.FEET);
        assertFalse(a.equals(b), "2 feet should not equal 3 feet");
    }

    @Test
    public void equalsIsReflexiveAndHandlesNullAndOtherTypes() {
        Length x = new Length(5, LengthUnit.INCH);
        assertTrue(x.equals(x), "equals should be reflexive");
        assertFalse(x.equals(null), "should not be equal to null");
        assertFalse(x.equals("not a length"), "should not be equal to a different type");
    }

    @Test
    public void demonstrateConversionTest() {
        Length l1 = new Length(1, LengthUnit.FEET);
        double inches = l1.demonstrateConversion(l1);
        assertEquals(12.0, inches, 1e-6, "1 foot should convert to 12 inches");
    }

    @Test
    public void demonstrateAdditionReturnsResultInL1Unit_simple() {
        // 1 foot + 12 inches = 24 inches => 2 feet
        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCH);

        // demonstrateAddition requires a target unit; we want the result in l1's unit
        Length result = Length.demonstrateAddition(l1, l2, l1.getUnit());

        assertEquals(LengthUnit.FEET, result.getUnit(), "Result unit should be the same as the first operand's unit");
        assertEquals(2.0, result.getValue(), 1e-6, "1 ft + 12 in should be 2 ft");

        // Also verify equality using equals (based on base-inch normalization)
        assertTrue(result.equals(new Length(2, LengthUnit.FEET)));
    }

    @Test
    public void demonstrateAdditionReturnsResultInL1Unit_mixedUnits() {
        // 1 cm (0.393701 in) + 1 in = 1.393701 in => in cm: 1.393701 / 0.393701 = ~3.540006
        Length l1 = new Length(1.0, LengthUnit.CENTIMETER);
        Length l2 = new Length(1.0, LengthUnit.INCH);

        Length result = Length.demonstrateAddition(l1, l2, l1.getUnit());

        assertEquals(LengthUnit.CENTIMETER, result.getUnit(), "Result unit should be the same as the first operand's unit");

        double expected = (l1.demonstrateConversion(l1) + l2.demonstrateConversion(l2)) / l1.getUnit().getConversionFactor();
        assertEquals(expected, result.getValue(), 1e-6, "Sum converted back into L1's unit should match expected");
    }

}
