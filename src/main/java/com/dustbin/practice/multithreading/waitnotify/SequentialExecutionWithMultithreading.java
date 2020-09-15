package com.dustbin.practice.multithreading.waitnotify;

public class SequentialExecutionWithMultithreading {

	private static Object lock = new Object();
	private static int counter = 0;

	private static class Thread01 extends Thread {

		@Override
		public void run() {
			synchronized (lock) {
				while (counter <= 20) {
					if (counter % 2 == 0) {
						System.out.println("even number " + counter);
						counter++;
						lock.notify();
					} else {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				}
			}
		}
	}

	private static class Thread02 extends Thread {

		@Override
		public void run() {
			synchronized (lock) {
				while (counter <= 20) {
					if (counter % 2 != 0) {
						System.out.println("odd number " + counter);
						counter++;
						lock.notify();
					} else {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		Thread01 thread01 = new Thread01();
		Thread02 thread02 = new Thread02();
		thread01.start();
		thread02.start();

		thread01.join();
		thread02.join();

	}

}
