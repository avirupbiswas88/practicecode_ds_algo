package com.dustbin.practice.algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

	static int[] bubbleSort(int[] array) {

		int temp, flag;
		for (int j = 1; j < array.length; j++) {
			flag = 0;
			for (int i = 0; i < array.length - j; i++) {
				if (array[i] > array[i + 1]) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					flag = 1;
				}
			//	System.out.println("loop- "+j);
			}
			if (flag == 0)
				break;
		}
		return array;
	}

	public static void main(String[] args) {
		int[] array = { 5,4,3,2,1,0 };
		System.out.println("unsorted array- "+Arrays.toString(array));
		int[] sortedArray = bubbleSort(array);
		System.out.println("sorted array- "+Arrays.toString(sortedArray));
	}

}
