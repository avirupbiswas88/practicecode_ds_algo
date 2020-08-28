package com.dustbin.practice.algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void mergeSort(int[] array) {
		int arrayLength = array.length;
		int middleIndex;
		int[] leftArray, rightArray;
		if (arrayLength > 1) {
			middleIndex = arrayLength / 2;
			leftArray = new int[middleIndex];
			rightArray = new int[arrayLength - middleIndex];
			for (int i = 0; i < middleIndex; i++) {
				leftArray[i] = array[i];
			}
			for (int i = middleIndex; i < arrayLength; i++) {
				rightArray[i - middleIndex] = array[i];
			}
			mergeSort(leftArray);
			mergeSort(rightArray);
			merge(leftArray,rightArray,array);
		}
	}

	public static void merge(int[] leftArray, int[] rightArray, int[] array) {

		int i = 0, j = 0, k = 0;
		while (i < leftArray.length && j < rightArray.length) {
			if (leftArray[i] <= rightArray[j]) {
				array[k] = leftArray[i];
				i++;
			} else if (leftArray[i] > rightArray[j]) {
				array[k] = rightArray[j];
				j++;
			}
			k++;
		}

		while (i < leftArray.length) {
			array[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < rightArray.length) {
			array[k] = rightArray[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args) {
		int[] array = { 2, 4, 21, 16, 9, 5, 8, 13, 29, 1, 3 };
		System.out.println("unsorted array- " + Arrays.toString(array));
		mergeSort(array);
		System.out.println("sorted array- " + Arrays.toString(array));
	}

}
