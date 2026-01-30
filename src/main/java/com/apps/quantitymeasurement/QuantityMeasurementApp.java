package com.apps.quantitymeasurement;

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

            if (!(obj instanceof Feet))
                return false;

            Feet feet = (Feet) obj;
            return Double.compare(this.value, feet.value) == 0;
        }


    }

    public static class Inches{
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj){
            if(this==obj)
                return true;

            if (this==null)
                return false;

            if (!(obj instanceof Inches ))
                return false;

            Inches inch= (Inches) obj;
            return Double.compare(this.value, inch.value)==0;
        }
    }

    public static void demonstrateFeetEquality(){


        Feet feet1= new Feet(1);
        Feet feet2= new Feet(1);



        System.out.println("Feet Equals" + feet1.equals(feet2) );

    }

    public static void demonstrateInchEquality(){


        Inches inch1= new Inches(1);
        Inches inch2= new Inches(1);

        System.out.println("Feet Equals" + inch1.equals(inch2) );

    }


    public static void main(String[] args) {
       demonstrateFeetEquality();
       demonstrateInchEquality();


    }


}
