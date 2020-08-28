package com.dustbin.practice.multithreading;

import java.math.BigInteger;
import java.util.*;

public class ThreadCoordinationWithJoin {

	public static void main(String[] args) throws InterruptedException {
		List<Long> numbers = Arrays.asList(100000000L, 3435L, 2324L, 35435L, 4656L, 23L, 2435L, 5566L);

		List<FactorialThread> threads = new ArrayList<>();
		for (Long number : numbers) {
			threads.add(new FactorialThread(number));
		}

		for (FactorialThread thread : threads) {
			thread.setDaemon(true);
			thread.start();
		}

		for (FactorialThread thread : threads) {
			thread.join(2000);
		}

		for (int i = 0; i < numbers.size(); i++) {
			FactorialThread thread = threads.get(i);
			if (thread.isFinished) {
				System.out.println("factorial of " + numbers.get(i) + " is " + thread.getResult());
			} else {
				System.out.println("the factorial calculation for " + numbers.get(i) + " is still in progress");
			}
		}

	}

	public static class FactorialThread extends Thread {
		private long inputNumbar;
		private BigInteger result = BigInteger.ZERO;
		private boolean isFinished = false;

		public FactorialThread(long inputNumbar) {
			this.inputNumbar = inputNumbar;
		}

		public BigInteger getResult() {
			return result;
		}

		public boolean isFinished() {
			return isFinished;
		}

		public BigInteger factorial(long inputNumbar) {
			BigInteger tempResult = BigInteger.ONE;

			for (long i = inputNumbar; i > 0; i--) {
				tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
			}

			return tempResult;
		}

		@Override
		public void run() {
			this.result = factorial(inputNumbar);
			this.isFinished = true;
		}

	}

}
