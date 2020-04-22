package com.java.algo.greedy.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/maximize-sum-arrii/
 
Given an array of N integers. You are allowed to rearrange the element of the array. The task is to find the maximum value of Σarr[i]*i, where i = 0, 1, 2,…., n – 1.

Examples:

Input : N = 4, arr[] = { 3, 5, 6, 1 }
Output : 31
If we arrange arr[] as { 1, 3, 5, 6 }. 
Sum of arr[i]*i is 1*0 + 3*1 + 5*2 + 6*3 
= 31, which is maximum

Input : N = 2, arr[] = { 19, 20 }
Output : 20
 
*/

public class MaxProductSum {
	
	public int getMaximumProduct(int[] input, int size) {
		
		int maxProduct = 0;
		
		Arrays.parallelSort(input);
		
		for(int i=0; i<size; i++) {
			maxProduct += input[i]*i;
		}
		
		return maxProduct;
		
	}
	
	
	public void testGetMaximumProduct() {
		assertEquals(31, getMaximumProduct(new int[] {3, 5, 6, 1}, 4));
		assertEquals(20, getMaximumProduct(new int[] {19, 20}, 2));
	}

}
