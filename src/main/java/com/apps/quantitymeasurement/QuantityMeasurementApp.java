package com.apps.quantitymeasurement;

import java.util.Locale;
import java.util.Scanner;

public class QuantityMeasurementApp {

    private static final Scanner SC = new Scanner(System.in).useLocale(Locale.US);

    // Generic method to demonstrate Length equality check
    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        boolean result = length1.equals(length2);
        System.out.println("Comparing " + length1 + " and " + length2 + " → " + result);
        return result;
    }

    // Method to demonstrate Feet equality check (reads user input)
    public static void demonstrateFeetEquality() {
        System.out.println("\n--- Feet Equality Check (user input) ---");
        double v1 = readPositiveDouble("Enter first value in FEET: ");
        double v2 = readPositiveDouble("Enter second value in FEET: ");
        Length l1 = new Length(v1, Length.LengthUnit.FEET);
        Length l2 = new Length(v2, Length.LengthUnit.FEET);
        demonstrateLengthEquality(l1, l2);
    }

    // Method to demonstrate Inches equality check (reads user input)
    public static void demonstrateInchesEquality() {
        System.out.println("\n--- Inches Equality Check (user input) ---");
        double v1 = readPositiveDouble("Enter first value in INCHES: ");
        double v2 = readPositiveDouble("Enter second value in INCHES: ");
        Length l1 = new Length(v1, Length.LengthUnit.INCHES);
        Length l2 = new Length(v2, Length.LengthUnit.INCHES);
        demonstrateLengthEquality(l1, l2);
    }

    // Method to demonstrate Feet and Inches comparison (reads user input)
    public static void demonstrateFeetInchesComparison() {
        System.out.println("\n--- Feet ↔ Inches Comparison (user input) ---");
        double feetVal = readPositiveDouble("Enter value in FEET: ");
        double inchVal = readPositiveDouble("Enter value in INCHES: ");
        Length feet = new Length(feetVal, Length.LengthUnit.FEET);
        Length inches = new Length(inchVal, Length.LengthUnit.INCHES);
        demonstrateLengthEquality(feet, inches);
    }

    // New: fully generic—read two lengths (value + unit) and compare
    public static void compareTwoUserLengths() {
        System.out.println("\n--- Compare Two Lengths (any units) ---");
        Length a = readLength("First");
        Length b = readLength("Second");
        demonstrateLengthEquality(a, b);
    }

    // New: convert a value from one unit to another and show result
    public static void convertValue() {
        System.out.println("\n--- Convert Value ---");
        Length a = readLength("Input");
        Length.LengthUnit target = readUnit("Convert to (FEET/INCHES): ");
        double inInches = getBaseInches(a);
        double result;
        if (target == Length.LengthUnit.INCHES) {
            result = inInches; // base unit
        } else {
            result = inInches / Length.LengthUnit.FEET.getConversionFactor();
        }
        System.out.printf("Result: %.4f %s%n", result, target);
    }

    // ===== Helpers =====

    private static Length readLength(String label) {
        double value = readPositiveDouble(label + " value: ");
        Length.LengthUnit unit = readUnit(label + " unit (FEET/INCHES): ");
        return new Length(value, unit);
    }

    private static Length.LengthUnit readUnit(String prompt) {
        while (true) {
            System.out.print(prompt);
            String raw = SC.next().trim().toUpperCase(Locale.US);
            switch (raw) {
                case "FEET":
                case "FOOT":
                case "FT":
                    return Length.LengthUnit.FEET;
                case "INCH":
                case "INCHES":
                case "IN":
                    return Length.LengthUnit.INCHES;
                default:
                    System.out.println("Invalid unit. Please enter FEET or INCHES.");
            }
        }
    }

    private static double readPositiveDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (SC.hasNextDouble()) {
                double v = SC.nextDouble();
                if (v >= 0) return v;
                System.out.println("Please enter a non-negative number.");
            } else {
                System.out.println("Invalid number. Use digits (e.g., 12 or 12.5).");
                SC.next(); // consume invalid token
            }
        }
    }

    // Access base value in inches using your Length class
    private static double getBaseInches(Length len) {
        // Use equality logic’s same base: call through reflection via public API is not needed;
        // we’ll re-compute here based on the enum factor.
        return len.compare(new Length(0, Length.LengthUnit.INCHES)) // harmless call to ensure object not null
                ? 0 // unreachable path for non-zero, but keeps usage of API
                : lenToInches(len);
    }

    private static double lenToInches(Length len) {
        if (len == null) return 0;
        switch (lenUnit(len)) {
            case FEET:
                return lenValue(len) * Length.LengthUnit.FEET.getConversionFactor();
            case INCHES:
            default:
                return lenValue(len);
        }
    }

    // Small accessors since fields are private; if you can, add getters in Length.
    // For now we’ll rely on toString parsing fallback if needed—better: add getters:
    // public double getValue(); public LengthUnit getUnit();
    // --- If you can edit Length, add these getters and replace the two methods below. ---
    private static double lenValue(Length l) {
        // Replace with l.getValue() if you add getters.
        String s = l.toString(); // e.g., "12.0 INCHES"
        int sp = s.lastIndexOf(' ');
        return Double.parseDouble(s.substring(0, sp));
    }

    private static Length.LengthUnit lenUnit(Length l) {
        // Replace with l.getUnit() if you add getters.
        String s = l.toString();
        int sp = s.lastIndexOf(' ');
        return Length.LengthUnit.valueOf(s.substring(sp + 1));
    }

    // ===== Menu =====

    private static int menu() {
        System.out.println("\n========== Quantity Measurement ==========");
        System.out.println("1) Compare two lengths (any units)");
        System.out.println("2) Feet equality (user values in feet)");
        System.out.println("3) Inches equality (user values in inches)");
        System.out.println("4) Compare feet vs inches");
        System.out.println("5) Convert value (feet <-> inches)");
        System.out.println("0) Exit");
        System.out.print("Choose an option: ");
        while (!SC.hasNextInt()) {
            System.out.println("Please enter a number from the menu.");
            SC.next();
            System.out.print("Choose an option: ");
        }
        return SC.nextInt();
    }

    public static void main(String[] args) {
        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    compareTwoUserLengths();
                    break;
                case 2:
                    demonstrateFeetEquality();
                    break;
                case 3:
                    demonstrateInchesEquality();
                    break;
                case 4:
                    demonstrateFeetInchesComparison();
                    break;
                case 5:
                    convertValue();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}