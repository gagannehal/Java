package com.java.algo.greedy.arrays;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/*
 
http://geeksforgeeks.org/minimum-product-subset-array/
 
Minimum product subset of an array
Given an array a, we have to find minimum product possible with the subset of elements present in the array. The minimum product can be single element also.

Examples:

Input : a[] = { -1, -1, -2, 4, 3 }
Output : -24
Explanation : Minimum product will be ( -2 * -1 * -1 * 4 * 3 ) = -24

Input : a[] = { -1, 0 }
Output : -1
Explanation : -1(single element) is minimum product possible
 
Input : a[] = { 0, 0, 0 }
Output : 0
 
 */

public class MinProduct {

	public int getMinProduct(int[] input) {
		int minProduct = 0;
		boolean negativePresent = false;
		boolean nonZero = false;
		int minNegative = Integer.MIN_VALUE;
		int minPositive = Integer.MAX_VALUE;
		int secondMinPositive = Integer.MAX_VALUE - 1;
		int initialCount = 0;

		for (int i = 0; i < input.length; i++) {
			var currentValue = input[i];

			if (currentValue != 0) {
				nonZero = true;
				if(initialCount==0) {
					minProduct = currentValue;
					initialCount++;
				} else {
					minProduct *= currentValue;
				}
			}

			if (currentValue < 0 && currentValue >= minNegative) {
				negativePresent = true;
				minNegative = currentValue;
			} else {
				if (currentValue < minPositive) {
					minPositive = currentValue;
				} else if (secondMinPositive < currentValue) {
					secondMinPositive = currentValue;
				}
			}
		}

		if (nonZero) {
			if (minProduct > 0) {
				if (negativePresent) {
					minProduct = minProduct / minNegative;
				} else {
					minProduct = minPositive * secondMinPositive;
				}

			}
		} else {
			minProduct = 0;
		}

		return minProduct;
	}

	@Test  
    public void findMinProd(){  
        assertEquals(-24,getMinProduct(new int[]{ -1, -1, -2, 4, 3}));  
        assertEquals(0,getMinProduct(new int[]{0, 0, 0}));  
        assertEquals(-1,getMinProduct(new int[]{-1, 0}));  
    }  

}
