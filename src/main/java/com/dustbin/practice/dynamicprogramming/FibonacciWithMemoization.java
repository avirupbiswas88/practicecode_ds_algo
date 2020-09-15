package com.dustbin.practice.dynamicprogramming;

import java.util.Arrays;

public class FibonacciWithMemoization {

	private static int[] array;

	private static int fibonacci(int value) {

		if (value <= 1)
			return value;
		return fibonacci(value - 1) + fibonacci(value - 2);
	}

	private static int fibonacciUsingMemoization(int value) {

		if (array[value] == -1) {
			if (value <= 1) {
				array[value] = value;
			} else {
				array[value] = fibonacciUsingMemoization(value - 1) + fibonacciUsingMemoization(value - 2);
			//	System.out.println(Arrays.toString(array));
			}
		}

		return array[value];
	}
	
	private static int fibonacciUsingTabulation(int value) {
		int[] tabArray = new int[value+1];
		tabArray[0] = 0;
		tabArray[1] = 1;
		for(int i=2;i<tabArray.length;i++) {
			tabArray[i] = tabArray[i-1] + tabArray[i-2];
		}
		
		return tabArray[value];
	}

	public static void main(String[] args) {

		// System.out.println(fibonacci(6));

		int fibNumber = 40;
		array = new int[fibNumber + 1];
		for (int i = 0; i < array.length; i++) {
			array[i] = -1;
		}

		System.out.println(fibonacciUsingMemoization(fibNumber));
		
		System.out.println(fibonacciUsingTabulation(fibNumber));

	}

}
