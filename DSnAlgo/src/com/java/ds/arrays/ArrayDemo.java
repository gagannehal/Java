package com.java.ds.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
 
 
There is no shortcut for converting from int[] to List<Integer> as Arrays.asList does not deal with boxing and will just create a List<int[]> which is not what you want. 
You have to make a utility method.

int[] ints = {1, 2, 3};
List<Integer> intList = new ArrayList<Integer>(ints.length);
for (int i : ints)
{
    intList.add(i);
}

 */

public class ArrayDemo {

	public static void main(String[] args) {

		int[] values = { 7, 2, 1, 12, 9, 3, 8, 4, 5, 23, 17 };

		//sortArray(values);

		//sortArrayParallel(values);
		
		//sortArrayStream(values);
		
		bubbleSort(values);

	}

	
	
	public static void sortArray(int[] values) {

		long startTime = System.nanoTime();
		// Sorting an array
		Arrays.sort(values);

		long endTime = System.nanoTime();

		// Arrays.toString() is used to print array
		System.out.print(Arrays.toString(values));
		System.out.println("Total time taken - " + (endTime - startTime));
	}

	
	
	public static void sortArrayParallel(int[] values) {

		long startTime = System.nanoTime();
		// Sorting an array
		Arrays.parallelSort(values);

		long endTime = System.nanoTime();

		// Arrays.toString() is used to print array
		System.out.print(Arrays.toString(values));
		System.out.println("Total time taken in parallel sort- " + (endTime - startTime));
	}
	
	
	
	public static void sortArrayStream(int[] values) {

		long startTime = System.nanoTime();

		// Using Arrays.stream() to convert 
        // array into Stream 
        IntStream stream = Arrays.stream(values).sorted();
        long endTime = System.nanoTime();
        
        stream.forEach(System.out::println);

		// Arrays.toString() is used to print array
		System.out.print(Arrays.toString(values));
		System.out.println("Total time taken in Stream sort- " + (endTime - startTime));
	}

	
	public static void bubbleSort(int[] values) {

		long startTime = System.nanoTime();
		// Sorting an array
		for(int i=values.length-1; i>=0; i--) {
			
			for(int j=i-1; j>=0;j--) {
				int temp;
				if (values[i]<values[j]) {    //17 23
					temp = values[j];          //temp = 23;
					values[j] = values[i];    //values[j] = 17 
					values[i] = temp;         // current = 23
				}
				
			}
			
		}
		
		long endTime = System.nanoTime();

		System.out.print(Arrays.toString(values));
		System.out.println("Total time taken - " + (endTime - startTime));
	}
	
}
