package com.java.misc;

import java.util.HashMap;
import java.util.Stack;

public class StackImplementation {

	public static void main(String[] args) {

		System.out.println(isValid("()"));

	}
	
	 public static boolean isValid(String s) {
	        
	        HashMap<String,String> counts = new HashMap<String,String>();
	        counts.put(")","(");
	        counts.put("}","{");
	        counts.put("]","[");
	        
	        Stack<String> values = new Stack<>();
	        
	        String[] array = s.split("");
	        
	        for(String value:array){
	            if(!counts.containsKey(value)){
	                values.push(value);
	            } else{
	                String currentValue = values.pop();
	                if(counts.get(value)!=currentValue){
	                    return false;
	                }                
	            }
	        }
	        return true;
	    }

}
