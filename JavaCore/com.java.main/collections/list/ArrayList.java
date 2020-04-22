package collections.list;

import model.Student;

public class ArrayList {

	public static void main(String[] args) {
		Student s1 = new Student("John", 1);
		Student s2 = new Student("John",1);
		System.out.println(s1.equals(s2));

	}

}
