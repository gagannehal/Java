package model;

public class Student {

	private String name;
	private int rollNum;
	static String school;
	
	static{
		school = "DPS";
	}

	public Student(String name, int rollNum) {
		super();
		this.name = name;
		this.rollNum = rollNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNum() {
		return rollNum;
	}

	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Student) {
			if(((Student)obj).name != null && ((Student)obj).rollNum!= 0) {
				if(((Student)obj).name == this.name && ((Student)obj).rollNum == this.rollNum) {
					return true;
				} else return false;
			} else return false;
		} else return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + rollNum;
		return result;
	}
	
	
}
