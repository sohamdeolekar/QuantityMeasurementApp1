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
}
