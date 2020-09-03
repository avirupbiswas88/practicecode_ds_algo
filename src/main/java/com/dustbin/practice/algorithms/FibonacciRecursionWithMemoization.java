package com.dustbin.practice.algorithms;

public class FibonacciRecursionWithMemoization {

	private static int[] storageArray;

	private static int fibonacchi(int number) {

		if (storageArray[number] != -1) {
			return storageArray[number];
		} else {
			storageArray[number] = fibonacchi(number - 1) + fibonacchi(number - 2);
			return storageArray[number];
		}

	}

	public static void main(String[] args) {

		storageArray = new int[51];
		for (int i = 0; i < storageArray.length; i++) {
			storageArray[i] = -1;
		}
		storageArray[0] = 0;
		storageArray[1] = 1;
		// 1 1 2 3 5 8 13 21 34 55
		Long startTime = System.currentTimeMillis();
		System.out.println(fibonacchi(45));
		Long endTime = System.currentTimeMillis();

		System.out.println("execution time " + (endTime - startTime));

	}

}
