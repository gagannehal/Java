package com.java.algo.greedy.arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
 
 https://www.geeksforgeeks.org/maximum-product-subset-array/
 
Given an array a, we have to find maximum product possible with the subset of elements present in the array. The maximum product can be single element also.

Examples:

Input : a[] = { -1, -1, -2, 4, 3 }
Output : 24
Explanation : Maximum product will be ( -2 * -1 * 4 * 3 ) = 24

Input : a[] = { -1, 0 }
Output : 0
Explanation : 0(single element) is maximum product possible
 
Input : a[] = { 0, 0, 0 }
Output : 0
 
 
 */

public class MaxProduct {

	public int getMaxProduct(int[] input) {

		int maxProduct = 0;
		int smallestNegative = Integer.MIN_VALUE;
		boolean nonZero = false;
		int initialCount = 0;
		boolean isPositive = false;

		for (int i = 0; i < input.length; i++) {
			var currentValue = input[i];
			if (currentValue != 0) {
				nonZero = true;
				if(initialCount==0) {
					maxProduct = currentValue;
					initialCount++;
				} else {
					maxProduct *= currentValue;
				}
				
			}
			if (currentValue < 0) {
				if (currentValue > smallestNegative) {
					smallestNegative = currentValue;
				}
			}
			
			if (currentValue > 0) {
				isPositive = true;
			}
		}
		
		
		if(nonZero) {
			if(maxProduct<0 && isPositive) {
				maxProduct = maxProduct/smallestNegative;
			} 
			
			if(maxProduct<0 && !isPositive) {
				maxProduct = 0;
			}
		} else {
			maxProduct= 0;
		}
		return maxProduct;
	}

	@Test
	public void testGetMaxProduct() {
		assertEquals(24,getMaxProduct(new int[]{ -1, -1, -2, 4, 3}));  
        assertEquals(0,getMaxProduct(new int[]{0, 0, 0}));  
        assertEquals(0,getMaxProduct(new int[]{-1, 0}));
	}
}
