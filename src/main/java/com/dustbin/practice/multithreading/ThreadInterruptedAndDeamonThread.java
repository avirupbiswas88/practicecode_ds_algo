package com.dustbin.practice.multithreading;

import java.math.BigInteger;

public class ThreadInterruptedAndDeamonThread {

	public static void main(String[] args) {

		 Thread thread = new Thread(new BlockingTasks());
		//Thread thread = new Thread(new LongComputationTasks(new BigInteger("200000"), new BigInteger("10000000")));

		//thread.setDaemon(true);
		thread.start();
		thread.interrupt();
	}

	public static class BlockingTasks implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(50000000);
			} catch (InterruptedException e) {
				System.out.println("Exiting blocking thread");
			}

		}

	}

	public static class LongComputationTasks implements Runnable {

		private BigInteger base;
		private BigInteger power;

		public LongComputationTasks(BigInteger base, BigInteger power) {
			this.base = base;
			this.power = power;
		}

		@Override
		public void run() {
			System.out.println(base + "^" + power + " = " + pow(base, power));

		}

		private BigInteger pow(BigInteger base, BigInteger power) {
			BigInteger result = BigInteger.ONE;

			for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
				if (Thread.currentThread().isInterrupted()) {
					System.out.println("prematurely interrupted computations");
					return BigInteger.ZERO;
				}
				result = result.multiply(base);

			}

			return result;
		}
	}

}
