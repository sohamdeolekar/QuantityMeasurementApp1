package com.apps.quantitymeasurement;

import java.util.Scanner;


public class QuantityMeasurementApp {
    public static void main(String[] args) {

       Length L1 = new Length(1, LengthUnit.FEET);
       Length L2 = new Length(0.33333333, LengthUnit.YARD);

        System.out.println("Equality is " + L1.equals(L2));

        Length L3 = new Length(1.0, LengthUnit.CENTIMETER);
        Length L4 = new Length(0.393701, LengthUnit.INCH);

        System.out.println("Equality is " + L3.equals(L4));

        Length L5 = new Length(1, LengthUnit.YARD);
        Length L6 = new Length(36, LengthUnit.INCH);

        System.out.println("Equality is " + L5.equals(L6));








    }


}
