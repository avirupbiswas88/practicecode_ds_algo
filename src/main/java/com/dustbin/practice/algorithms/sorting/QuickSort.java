package com.dustbin.practice.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {
		int[] array = { 2, 4, 21, 16, 9, 5, 8, 13, 29, 1, 3 };
		System.out.println("unsorted array- " + Arrays.toString(array));
		quickSort(array, 0, array.length - 1);
		System.out.println("sorted array- " + Arrays.toString(array));

		// System.out.println(new Random().nextInt(array.length - 1));

	}

	private static void quickSort(int[] array, int start, int end) {

		if (start < end) {
			//int pivotIndex = partitionArray(array, start, end);
			int pivotIndex = randomizePartitionArray(array, start, end);
			quickSort(array, start, pivotIndex - 1);
			quickSort(array, pivotIndex + 1, end);
		}
	}

	private static int partitionArray(int[] array, int start, int end) {

		int pivotIndex = 0;
		int tempElement;
		int pivotElement = array[end];
		for (int i = 0; i < end; i++) {
			if (array[i] <= pivotElement) {
				tempElement = array[pivotIndex];
				array[pivotIndex] = array[i];
				array[i] = tempElement;
				pivotIndex++;
			}
		}
		tempElement = array[pivotIndex];
		array[pivotIndex] = array[end];
		array[end] = tempElement;

		return pivotIndex;
	}

	private static int randomizePartitionArray(int[] array, int start, int end) {

		int randomIndex = new Random().nextInt(end);
		int temp = array[end];
		array[end] = array[randomIndex];
		array[randomIndex] = temp;
		int pivotIndex = 0;
		int tempElement;
		int pivotElement = array[end];
		for (int i = 0; i < end; i++) {
			if (array[i] <= pivotElement) {
				tempElement = array[pivotIndex];
				array[pivotIndex] = array[i];
				array[i] = tempElement;
				pivotIndex++;
			}
		}
		tempElement = array[pivotIndex];
		array[pivotIndex] = array[end];
		array[end] = tempElement;

		return pivotIndex;
	}

}
