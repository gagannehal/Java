package com.java.functionalinterfaces;

/*
Type		Functional Interface	Abstract Method		Description
Supplier	Supplier<T>				T get()				Function that denotes a supplier of results

 */


import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

class Employee4 {
	
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
	
	public Employee4(int empId, String empname, double sal, int exp, String gender) {
		super();
		this.empId = empId;
		this.empname = empname;
		this.sal = sal;
		this.exp = exp;
		this.gender = gender;
	}
	
	public double generateSalarySlip() {
		System.out.println("SalarySlip of Employee4");
		return this.getSal();		//no increment
	}
	
	public static List<Employee4> getEmployee4s()
	{
		List <Employee4> newlist=new ArrayList<>();
		newlist.add(new Employee4(100, "Unnati", 35000D, 10, "F"));
		newlist.add(new Employee4(104, "Sneha", 25000D, 8, "F"));
		
		newlist.add(new FullTimeEmployee4(107,"Nikhil",40000D,5,"M"));
		newlist.add(new FullTimeEmployee4(101, "Kiran", 33000D, 2, "M"));
		
		newlist.add(new PartTimeEmployee4(103, "Salma", 15000D, 3, "M"));
		newlist.add(new PartTimeEmployee4(102, "Celine", 20000D, 4, "F"));
		
		return newlist;
	}
} 

class FullTimeEmployee4 extends Employee4
{
	public double generateSalarySlip() {
		System.out.println("SalarySlip of FullTime Employee4");
		return super.getSal()*1.20;			//20% increment
	}
	
	public FullTimeEmployee4(int empId, String empname, double sal, int exp, String gender) {
		super(empId, empname, sal,exp,gender);
		// TODO Auto-generated constructor stub
	}
}

class PartTimeEmployee4 extends Employee4
{
	public double generateSalarySlip() {
		System.out.println("SalarySlip of PartTime Employee4");
		return super.getSal()*1.10;		//10% increment
	}
	
	public PartTimeEmployee4(int empId, String empname, double sal, int exp, String gender) {
		super(empId, empname, sal,exp,gender);
		// TODO Auto-generated constructor stub
	}
}

class SupplierDemo {
	public static void main(String[] args) {
		
        List<? extends Employee4> lstEmp = Employee4.getEmployee4s();
        for (Employee4 e : lstEmp) {
            generate(() -> e);
        }
    }

    public static void generate(Supplier<? extends Employee4> supplier) {
        System.out.println(supplier.get().generateSalarySlip());
    }
} 

