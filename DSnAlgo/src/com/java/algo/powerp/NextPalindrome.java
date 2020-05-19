package com.java.algo.powerp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class NextPalindrome {
	
	
	public int getNextPalindrome(int value) {
		
		int nextPalindrome = 0;
		
		int length = (int)(Math.log10(value)+1);
		
		if(length%2==0) {
			
			nextPalindrome = (int) (value + 11*Math.pow(10, ((length/2)-1)));
			
		} else {
			
			nextPalindrome = (int) (value + Math.pow(10, ((length/2))));
		}
		
		return nextPalindrome;
	}
	
	
	@Test
	public void testGetNextPalindrome() {
			
		assertEquals(33, getNextPalindrome(22));
		assertEquals(12421, getNextPalindrome(12321));
		assertEquals(12355321, getNextPalindrome(12344321));
		
	}

}
