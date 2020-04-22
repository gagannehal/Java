package com.java.functionalinterfaces;

/*
Type		Functional Interface	Abstract Method		Description
Function	Function<T, R>			R apply(T t)		Function that accepts single argument and produces result  
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class Employee1
{
	private Integer empId;
    private String name;
    private Double sal;
	
	public Employee1(Integer empId, String name, Double sal) {
		super();
		this.empId = empId;
		this.name = name;
		this.sal = sal;
	}
	
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String empName) {
		this.name = name;
	}
	
	public static List<Employee1> getEmpList()
	{
	    Employee1 e1 = new Employee1(101,"Aron",50000D);
    	Employee1 e2 = new Employee1(102,"Cindia",30000D);
    	Employee1 e3 = new Employee1(103,"Zidane",45000D);
    	List<Employee1> empList = new ArrayList<>(); 
    	empList.add(e1);
    	empList.add(e2);
    	empList.add(e3);
    	return empList;
	}
    
}

class FunctionDemo {
    //main method
    public static void main(String pars[]) {
        List<Employee1> lstEmp = Employee1.getEmpList();
        for (Employee1 e : lstEmp)  {
            double sal = computeSalary(e, e1 -> e1.getSal() * 1.1);    // 10% salary increment
            System.out.println(e.getName() + ": old salary: " + e.getSal() + ", new salary: " + sal);
        }
    }
 
    public static double computeSalary(Employee1 e, Function<Employee1, Double> fn) {
        return fn.apply(e);
    }
}
