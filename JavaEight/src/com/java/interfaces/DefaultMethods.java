package com.java.interfaces;

//The visibility of an overridden method cannot be reduced, which is by default public in an interface.


/*
This can be resolved with the help of the following set of rules:

Rule 1: Classes always win. A method definition in the class or its super class takes precedence over the default method definition that is available in the interface.

Rule 2: Otherwise, sub-interfaces win: the method with the exact signature in the most specific default-functionality providing interface will be selected.

Rule 3: If the choice continues to be ambiguous, the class that inherits multiple interfaces should explicitly select the default method implementation to be used just by overriding it and the overridden method should have an explicit call to the desired default behavior.

Now let us try to apply these rules to our Greeting example:

In our example, Rule 1 does not apply, as we do not have any class implementing the default interface.

As per Rule 2, "the most specific default providing interface" - in our example, interface GreetingExtn overrides the default method's definition that is available in the Greeting interface and hence is the most specific. Therefore, the implementation of GreetingExtn hello () method will be taken into consideration
*/

interface Greeting{
    default void hello() {
    	System.out.println(" hello from Greeting Interface");
    }
}

interface GreetingExtn extends Greeting{
     default void hello() {
	System.out.println(" hello from GreetingExtn Interface");
     }
}

class Greet {   //comment and uncomment this class to try more possibilities
    public void hello()  {
        System.out.println("hello from Greet Class");
    }
}

class DefaultMethods extends Greet implements Greeting, GreetingExtn{
   public static void main(String[] args) {
	    new DefaultMethods().hello();
   }
}

