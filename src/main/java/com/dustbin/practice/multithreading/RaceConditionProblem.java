package com.dustbin.practice.multithreading;

public class RaceConditionProblem {

	public static void main(String[] args) throws InterruptedException {

		LongWrapper longWrapper = new LongWrapper(0L);

		Runnable runnable = () -> {
			for (int i = 0; i < 1000; i++) {
				longWrapper.incrementValue();
			}
			// System.out.println(Thread.currentThread().getName());
		};

		Thread[] threadArray = new Thread[1000];
		for (int i = 0; i < threadArray.length; i++) {
			Thread t1 = new Thread(runnable);
			threadArray[i] = new Thread(runnable);
			threadArray[i].start();
		}

		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i].join();
		}
		// System.out.println(longWrapper.getValue());
		// System.out.println(Thread.currentThread().getName());
		System.out.println("value- "+longWrapper.getValue());

	}

}
