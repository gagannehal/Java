package com.java.algo.greedy.arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
 
 https://www.geeksforgeeks.org/maximum-sum-increasing-order-elements-n-arrays/
 
Maximum sum of increasing order elements from n arrays
Given n arrays of size m each. Find the maximum sum obtained by selecting a number from each array such that the elements selected from the i-th array are more than the element selected from (i-1)-th array. If maximum sum cannot be obtained then return 0.

Examples:

Input : arr[][] = {{1, 7, 3, 4},
                   {4, 2, 5, 1},
                   {9, 5, 1, 8}}
Output : 18
Explanation :
We can select 4 from first array, 5 from 
second array and 9 from third array.

Input : arr[][] = {{9, 8, 7},
                   {6, 5, 4},
                   {3, 2, 1}}
Output : 0

 
 
 */
public class MaxSumIncOrder {

	public static int getMaxSum(int[][] input) {

		int maxSum = 0;
		int previousNumber = Integer.MAX_VALUE;

		for (int row = input.length - 1; row >= 0; row--) {
			int maxNumberInRow = Integer.MIN_VALUE;
			int[] currentArray = input[row];
			boolean isValid = false;
			for (int col = 0; col < currentArray.length; col++) {
					if(currentArray[col]>maxNumberInRow && previousNumber>currentArray[col]) {
						isValid = true;
						maxNumberInRow = currentArray[col];
					}
			}
			if(isValid) {
				previousNumber = maxNumberInRow;
				maxSum += maxNumberInRow;
			} else {
				return 0;
			}
		}
		return maxSum;
	}
	
	
	@Test
	public void testGetMaxSum() {
		
		int[][] array1 = {{1, 7, 3, 4},
                		  {4, 2, 5, 1},
                		  {9, 5, 1, 8}};
		
		int[][] array2 = {{9, 8, 7},
			              {6, 5, 4},
			              {3, 2, 1}};
                
		assertEquals(18, getMaxSum(array1));
		assertEquals(0, getMaxSum(array2));
	}
	
//	public static void main(String[] arg) {
//		
//		int[][] array1 = {{1, 7, 3, 4},
//      		  {4, 2, 5, 1},
//      		  {9, 5, 1, 8}};
//		
//		System.out.println(getMaxSum(array1));
//		
//	}

}
