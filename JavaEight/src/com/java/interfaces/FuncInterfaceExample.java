package com.java.interfaces;


@FunctionalInterface
interface StringFormatter {
	
	void format(String s1, String s2);
}

public class FuncInterfaceExample {

	public static void main(String[] arg) {
		
		String string1 = "Lambda";
		String string2 = "Expression";
		StringFormatter sf = (String s1, String s2) -> { System.out.println(s1+" "+s2);};
		sf.format(string1, string2);
		
	}
}
