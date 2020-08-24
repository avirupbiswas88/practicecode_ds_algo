package com.dustbin.practice.algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {

	static int[] selectionSort(int[] array) {

		int minIndex,temp;

		for (int i = 0; i < array.length; i++) {
			minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}

			temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
		return array;
	}

	public static void main(String[] args) {

		int[] array = { 7, 2, 4, 1, 5, 3 };
		System.out.println("unsorted array- "+Arrays.toString(array));
		selectionSort(array);
		System.out.println("sorted array- "+Arrays.toString(array));

	}

}
