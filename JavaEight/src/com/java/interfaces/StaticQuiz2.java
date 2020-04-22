package com.java.interfaces;

/*
What will happen when the code is subjected to compilation and execution?

Correct - The code will not get compiled as the static method of interface is not accessed using interface name
Will get executed successfully leaving the output “deduct”
Will get executed successfully leaving the output “deduction for customer”
Will lead to run time ambiguity as the interface’s static method is overridden
 
 */

interface Deduction2 {
	static void deduct() {
		System.out.println("deduct");
	}
}
 class Customer2 implements Deduction2 {
	public static void deduct() {
		System.out.println("deduction for customer");
	}
}
public class StaticQuiz2 {
	public static void main(String[] args) {
		Deduction2 deduction = new Customer2();
		//deduction.deduct();
	}
}