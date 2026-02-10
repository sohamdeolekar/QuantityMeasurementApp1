package com.apps.quantitymeasurement;

import java.util.Scanner;


public class QuantityMeasurementApp {
    public static void main(String[] args) {

       Length L1 = new Length(1, LengthUnit.CENTIMETER);
       Length L2 = new Length(12, LengthUnit.INCH);

        System.out.println("Equality is " + L1.equals(L2));

        Length.demonstrateAddition(L1,L2);


       /* // print conversion outputs for L1 and L2
        System.out.println(L1 + " in inches = " + L1.demonstrateConversion(L1));
        System.out.println(L2 + " in inches = " + Length.demonstrateConversion(L2));

        Length L3 = new Length(1.0, LengthUnit.CENTIMETER);
        Length L4 = new Length(0.393701, LengthUnit.INCH);

        System.out.println("Equality is " + L3.equals(L4));

        System.out.println("Addition=" +Length.demonstrateAddition(L3,L4) + "Inches");

       /* // print conversion outputs for L3 and L4
        System.out.println(L3 + " in inches = " + L3.demonstrateConversion(L3));
        System.out.println(L4 + " in inches = " + Length.demonstrateConversion(L4));

        Length L5 = new Length(1, LengthUnit.YARD);
        Length L6 = new Length(36, LengthUnit.INCH);

        System.out.println("Equality is " + L5.equals(L6));

        // print conversion outputs for L5 and L6
        System.out.println(L5 + " in inches = " + L5.demonstrateConversion(L5));
        System.out.println(L6 + " in inches = " + Length.demonstrateConversion(L6));

        Length a = new Length(2, LengthUnit.FEET);
        System.out.println(a + " in inches = " + a.demonstrateConversion(L4));

         */


    }





}
