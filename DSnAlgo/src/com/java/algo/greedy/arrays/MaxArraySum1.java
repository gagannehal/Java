package com.java.algo.greedy.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

/*
 
 https://www.geeksforgeeks.org/maximize-array-sun-after-k-negation-operations/
 
Given an array of size n and a number k. We must modify array K number of times. Here modify array means in each operation we can replace any array element arr[i] by -arr[i]. We need to perform this operation in such a way that after K operations, sum of array must be maximum?

Examples :

Input : arr[] = {-2, 0, 5, -1, 2} 
        K = 4
Output: 10
// Replace (-2) by -(-2), array becomes {2, 0, 5, -1, 2}
// Replace (-1) by -(-1), array becomes {2, 0, 5, 1, 2}
// Replace (0) by -(0), array becomes {2, 0, 5, 1, 2}
// Replace (0) by -(0), array becomes {2, 0, 5, 1, 2}

Input : arr[] = {9, 8, 8, 5} 
        K = 3
Output: 20
 
 */

public class MaxArraySum1 {

	private static int getMaxSum(int[] input, int k) {

		int maxSum = 0;
		int minPositive = Integer.MAX_VALUE;
		boolean zeroPresent = false;
		boolean negativePresent = false;

		for (int i = 0; i < input.length; i++) {
			int currentValue = input[i];
			if (currentValue == 0) {
				zeroPresent = true;
				continue;
			} else if (currentValue > 0) {
				maxSum += currentValue;

				if (currentValue < minPositive) {
					minPositive = currentValue;
				}
			} else if (currentValue<0 && k>0){
				negativePresent = true;
				k--;
				maxSum += (-1*currentValue); 
			}
		}
		if (k > 0) {
			
			if(zeroPresent && !negativePresent) {
				return maxSum;
			}
			if (k % 2 != 0) {
				maxSum = maxSum - (minPositive * 2);
			}
		}
		return maxSum;
	}
	

	@Test
	public void testGetMaxSum() {
		assertEquals(10, getMaxSum(new int[]{-2, 0, 5, -1, 2},4));
		assertEquals(20, getMaxSum(new int[] { 9, 8, 8, 5 }, 3));
		//assertEquals(16, getMaxSum(new int[]{-2, 0, 5, -1, 2, -3, -4, -5},3));
	}

}
