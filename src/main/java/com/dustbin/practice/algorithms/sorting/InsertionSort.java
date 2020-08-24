package com.dustbin.practice.algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {

	static int[] insertionSort(int[] array) {

		int hole, value;
		for (int i = 1; i < array.length; i++) {
			hole = i;
			value = array[i];
			while (hole > 0 && array[hole - 1] > value) {
				array[hole] = array[hole - 1];
				hole--;
			}
			array[hole] = value;
		}
		return array;
	}

	public static void main(String[] args) {
		int[] array = { 2, 4, 21, 16, 9, 5, 8, 13, 29, 1, 3 };
		System.out.println("unsorted array- " + Arrays.toString(array));
		int[] sortedArray = insertionSort(array);
		System.out.println("sorted array- " + Arrays.toString(sortedArray));

	}

}
