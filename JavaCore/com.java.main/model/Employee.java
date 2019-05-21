package model;

public class Employee {
	
	private String name;
	private int empId;
	static String company;
	
	static {
		company = "Google";
	}
	
	public Employee(String name, int empId) {
		this.empId = empId;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

}
