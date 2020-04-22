package com.java.interfaces;

/*
 
 Functional interfaces strictly have abstract methods of count one. However, they are allowed to have any number of static or default methods. In addition, they can override some methods from java.lang.Object.
 
 */

@FunctionalInterface
interface Shape  {
    void draw();
    
    //Double perimeter(); //Uncomment the abstract method to observe the difference
    
    public default Double area(Integer radius)
    {
        return radius*3.14;
    }
    
    public default Double area(Double height, Double width)
    {
        return height*width;
    }
    
    public static void print()
    {
        System.out.println("Inside Shape");
    }
}

public class FunctionalInterfaceDemo {
	
	public static void main (String[] args) {
        Shape.print();
    }

}


