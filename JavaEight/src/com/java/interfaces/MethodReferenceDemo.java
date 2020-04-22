package com.java.interfaces;

/*
 
 Method Type						Lambda Expression					Method Reference
Static method						(String s) -> Integer.parseInt(s)	Integer::parseInt
Instance method of particular type	(String s) -> s.length()			String::length
Instance method of particular type	() -> emp.getEmpId()				emp::getEmpId
Constructor							(String s)->new String(s)			String::new
 
 */


import java.util.ArrayList;
import java.util.List;
/*
//Example with user defined method
interface Shape
{
     void display();
}

class MethodReferenceDemo 
{
    public static void methodDisplay()
    {
        System.out.println("Squircle");
    }
    
    public static void main (String[] args) {
        Shape s = MethodReferenceDemo::methodDisplay;
        s.display();
    }
}*/

//Example with predefined method
class Employee1
{
	private Integer empId;
    private String empName;
    private String country;
    
	public Employee1(Integer empId, String empName, String country) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.country = country;
	}
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", country=" + country + "]";
	}

	public static int compareByCountry(Employee employee1, Employee employee2) {
        return employee1.getCountry().compareTo(employee2.getCountry());
    }
    
}

class MethodReferenceDemo {  
    
    public static void main(String[] args) { 
    	Employee e1 = new Employee(101,"Aron","Spain");
    	Employee e2 = new Employee(102,"Cindia","Portugal");
    	Employee e3 = new Employee(103,"Zidane","France");
    	List<Employee> empList = new ArrayList<>(); 
    	empList.add(e1);
    	empList.add(e2);
    	empList.add(e3);
    	System.out.println("Before sorting : "+empList);
    	empList.sort(Employee1::compareByCountry);
    	System.out.println("After sorting : "+empList);
    }  
} 
