package com.java.ds.arrays;

import java.util.Arrays;

public class MergeSortDemo {

	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5 };

		System.out.println("Given Array");
		System.out.println(Arrays.toString(arr));

		long startTime = System.nanoTime();

		sort(arr, 0, arr.length - 1);

		long endTime = System.nanoTime();

		System.out.println("\nSorted array");
		System.out.println(Arrays.toString(arr));
		System.out.println("Total time taken - " + (endTime - startTime));

	}

	private static void sort(int[] values, int leftIndex, int rightIndex) {

		if (leftIndex < rightIndex) {
			int middleIndex = (leftIndex + rightIndex) / 2;
			sort(values, leftIndex, middleIndex);
			sort(values, middleIndex + 1, rightIndex);

			merge(values, leftIndex, middleIndex, rightIndex);

		}

	}

	private static void merge(int[] values, int leftIndex, int middleIndex, int rightIndex) {

		int leftArraySize = middleIndex - leftIndex + 1;
		int rightArraySize = rightIndex - middleIndex;

		int[] leftArray = new int[leftArraySize];
		int[] rightArray = new int[rightArraySize];

		for (int i = 0; i < leftArraySize; ++i) {
			leftArray[i] = values[leftIndex + i];
		}

		for (int j = 0; j < rightArraySize; ++j) {
			rightArray[j] = values[middleIndex + 1 + j];
		}

		int i = 0, j = 0;
		int currentIndex = leftIndex;

		while (i < leftArraySize && j < rightArraySize) {

			if (leftArray[i] >= rightArray[j]) {
				values[currentIndex] = rightArray[j];
				currentIndex++;
				j++;
			} else {
				values[currentIndex] = leftArray[i];
				i++;
				currentIndex++;
			}

		}

		while (i < leftArraySize) {
			values[currentIndex] = leftArray[i];
			i++;
			currentIndex++;
		}

		while (j < rightArraySize) {
			values[currentIndex] = rightArray[j];
			j++;
			currentIndex++;
		}

	}

}
