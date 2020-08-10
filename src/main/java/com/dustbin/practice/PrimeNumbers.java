package com.dustbin.practice;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

	public static List<Integer> primeNumbers(int range) {
		List<Integer> primeNumbers = new ArrayList<>();
		int counter = 0;
		for (int i = 2; i <= range; i++) {
			counter = 0;
			if (i == 2) {
				primeNumbers.add(i);
			} else {
				for (int j = 2; j < i; j++) {
					if (i % j == 0) {
						counter++;
						break;
					}
				}
				if (counter == 0)
					primeNumbers.add(i);

			}
		}

		return primeNumbers;
	}

	public static void main(String[] args) {

		System.out.println(primeNumbers(200));

	}

}
