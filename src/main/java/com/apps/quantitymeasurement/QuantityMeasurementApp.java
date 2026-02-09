package com.apps.quantitymeasurement;

import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class QuantityMeasurementApp {

    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;

            // use getClass() comparison instead of instanceof
            if (getClass() != obj.getClass())
                return false;

            Feet feet = (Feet) obj;
            return Double.compare(this.value, feet.value) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }


    public static void main(String[] args) {

        System.out.println("Welcome to Quantity Measurement App");

        System.out.println("Enter first feet value ");
        Scanner sc = new Scanner(System.in);
        float f1 = sc.nextFloat();

        System.out.println("Enter second feet value");
        float f2 = sc.nextFloat();

        Feet feet1 = new Feet(f1);
        Feet feet2 = new Feet(f2);

        System.out.println("Feet equal " + feet1.equals(feet2));


    }


}
