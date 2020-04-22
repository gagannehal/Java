package com.java.misc;


import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

@Repeatable(value = Authors.class)
@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
    String method();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Authors {
    Author[] value();
}

interface Remunerator {
    public abstract double deductFoodFee();
    public final double HEALTH_INSURANCE_PERCENTAGE = 5.0;
    public abstract double deductHealthInsurancePremium();
}

abstract class Employee implements Remunerator {
	public abstract double calculateSalary();
	
	private int empId;
	private String empname;
	private double sal;
	int exp;
	String gender;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Employee(int empId, String empname, double sal, int exp, String gender) {
		super();
		this.empId = empId;
		this.empname = empname;
		this.sal = sal;
		this.exp = exp;
		this.gender = gender;
	}
}


@Author(name="John", method="calculateSalary()")
@Author(name="James", method="deductFoodFee()")
@Author(name="Mark", method="deductHealthInsurancePremium()")
class FullTimeEmployee extends Employee {
	
    public FullTimeEmployee(int empId, String empname, double sal, int exp, String gender) {
		super(empId, empname, sal, exp, gender);
	}
    
	//field declarations
	public double calculateSalary() {
		// Salary calculation for full-time employee 
		return super.getSal();
	}
	
	public double deductFoodFee() {
		// Food fee deduction from salary
		return super.getSal()-super.getSal()*0.1;
	}
	public double deductHealthInsurancePremium() {
		return (HEALTH_INSURANCE_PERCENTAGE * super.getSal()) / 100;
	}
}

class RepeatAnnotation
{
	public static void main(String[] args) {
	    FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(101,"Brown",10000D,2,"M");
		Author[] authArray = FullTimeEmployee.class.getAnnotationsByType(Author.class);
		int[] marks;
		marks = new int[-10];
		marks[10] = 100;
		for(Author author: authArray)
		{
			System.out.println(author.name()+"     "+author.method());
		}
	}
}

