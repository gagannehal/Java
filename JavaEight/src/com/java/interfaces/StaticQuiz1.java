package com.java.interfaces;

/*
What will happen to the above code when compile and execute?

Correct - The code will not get compiled because the static method of interface is not accessed using interface name
Correct - The code will not get compiled as the method deduct() is undefined for the Customer class
Will get executed successfully leaving the output “deduct”
Will lead to run time ambiguity as the static method is not accessed using interface name
 
 */

 interface Deduction1 {
	static void deduct() {
		System.out.println("deduct");
	}
}
@SuppressWarnings("")
 class Customer1 implements Deduction1 {
	public void serviceCharge() {
        //deduction functionality being invoked
		//deduct();
	}
}
 class StaticQuiz1 {
	public static void main(String[] args) {
		//new customer().serviceCharge();	
	}
}