package com.java.stream;


import java.util.List;
import java.util.ArrayList;
import java.util.stream.*;
import java.util.Optional;

class Employee3
{
    private Integer id;
    private String name;
    private Integer sal;
    private Integer yearsInOrg;
    
    public String getName() {
		return name;
	}
	public Integer getSal() {
		return sal;
	}
	public void setSal(Integer sal) {
		this.sal = sal;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getYearsInOrg() {
		return yearsInOrg;
	}
	public void setYearsInOrg(Integer yearsInOrg) {
		this.yearsInOrg = yearsInOrg;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sal=" + sal + ", yearsInOrg=" + yearsInOrg + "]";
	}
	public Employee3(Integer id, String name, Integer sal, Integer yearsInOrg) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.yearsInOrg = yearsInOrg;
	}
	public static List<Employee3> getEmpList()
	{
	    Employee3 e1 = new Employee3(34578,"Cathy Ivy",35000,0);
    	Employee3 e2 = new Employee3(41234,"Damodar Charan",61000,0);
    	Employee3 e3 = new Employee3(22347,"Netaa Singh",100000,0);
    	Employee3 e4 = new Employee3(11345,"Brian Anderson",160000,3);
    	List<Employee3> empList = new ArrayList<>(); 
    	empList.add(e1);
    	empList.add(e2);
    	empList.add(e3);
    	empList.add(e4);
    	return empList;
	}
}

class ReduceDemo {
    public static void main(String[] args) {
        List <Employee3> lstEmp = Employee3.getEmpList();
	
        List<Employee3> lstNewEmp = lstEmp.stream().filter(emp -> emp.getYearsInOrg() < 1)
            .map(e -> { e.setSal(e.getSal() + 5000); return e; })    // Incrementing salary
            .collect(Collectors.toList());
 
        System.out.println("Employees less than a year old with increment:");
        lstNewEmp.forEach(e -> System.out.println(e.getId() + ":" + e.getName() + ":" + e.getSal())); 
 
        Optional<Integer> max = lstNewEmp.stream().map(e->e.getSal())
            .reduce(Integer::max);    // Finding the maximum salalry
        List<Employee3> lstMaxEmp =  lstNewEmp.stream()
            .filter(e -> e.getSal().equals(max.get()))    // Finding employees with the maximum salary
            .collect(Collectors.toList());
 
        System.out.println("\nEmployees having maximum salary after increment:");
        lstMaxEmp.forEach(e -> System.out.println(e.getId() + ":" + e.getName() + ":" + e.getSal())); 
    }
}
