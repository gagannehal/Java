package com.java.interfaces;

/*
 
Here are some observations about the static methods of interfaces:

Static methods in interfaces help providing utility methods. For example, null check, collection sorting, etc

Methods of java.lang.Object can never be defined as static methods in interfaces

The Comparator interface of Java 8 is a perfect example in which the static methods have been included: comparingInt(), comparingDouble(), comparingLong(), naturalOrder(), nullsFirst(), nullsLast() and reverseOrder()
 
 */

interface Remunerator {
    public abstract double deductFoodFee();                   
    final double HEALTH_INSURANCE_PERCENTAGE = 5.0;
    final double PENSION_PERCENTAGE = 5.0;
    
    public default double deductHealthInsurancePremium(double employeeSalary) {    
        return (employeeSalary * HEALTH_INSURANCE_PERCENTAGE / 100);
    }
 
    public static double deductForPension(double employeeSalary) {    // Static method of the interface
		return (employeeSalary * PENSION_PERCENTAGE / 100);
    }
}

class StaticMethods  {
    public static void main (String[] args) {
        Double pension = Remunerator.deductForPension(20000);
        System.out.println(pension);
    }
}
