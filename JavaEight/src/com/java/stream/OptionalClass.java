package com.java.stream;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Employee5
{
    private String name;
    private Integer id;
    private Double sal;
    
    private Optional<Passport> passport = Optional.empty();    // The container is initially empty
	
    public  Optional<Passport> getPassport() {
        return passport;
    }
    
    public void setPassport(Optional<Passport> passport) {
        this.passport = passport;
    }
    
    public String getName() {
		return name;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
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
	
	public Employee5(String name, Integer id, Double sal, Optional<Passport> passport) {
		super();
		this.name = name;
		this.id = id;
		this.sal = sal;
		this.passport = passport;
	}
	
	public Employee5() {
		//Default constructor
	}

	public static List<Employee5> getEmployeeList()
    {
    	List<Employee5> employeeList = new ArrayList<>();
    	//Creating employee objects with passport
    	Optional<Passport> p1 =Optional.of(new Passport(10121));
        Employee5 e1 = new Employee5("Robert",102,10000D,p1);
        
        Optional<Passport> p2 =Optional.of(new Passport(10122));
        Employee5 e2 = new Employee5("James",105,15000D,p2);
        
        //Creating employee objects without passport
        Employee5 e3 = new Employee5();
        e3.setId(107);
        e3.setName("Tyrion");
        e3.setSal(21000D);
        
        Employee5 e4 = new Employee5();
        e4.setId(110);
        e4.setName("Bruce");
        e4.setSal(8000D);
        
        //adding the objects into a list
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        
        return employeeList;
    }
}


class Passport {
    private int passportNo;
 
    public int getPassportNo() {
        return passportNo;
    }
    
    public Passport(int passportNo) {
		super();
		this.passportNo = passportNo;
	}
	public void setPassportNo(int passportNo) {
        this.passportNo = passportNo;
    }
}

class OptionalClass {
    public static void main(String[] args) {
        // Code to retrieve employees and to store them in a list called employeesList
		List<Employee5> employeesList = Employee5.getEmployeeList();
        List<Integer> passportNumbers = new ArrayList<>(); 
        // List to collect the passport numbers
        for(Employee5 employee : employeesList) {
        	passportNumbers.add(employee.getPassport().orElse(new Passport(0)).getPassportNo());
           }
        passportNumbers.forEach(x->System.out.println("Passport number: "+x));
        
    }
}
