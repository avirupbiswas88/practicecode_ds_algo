package com.dustbin.practice.multithreading;

public class ThreadRunnableInterfaceImpl {

	public static void main(String[] args) {

		//creating thread with Runnable interface
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("inside thread " + Thread.currentThread().getName() + " with priority set "
						+ Thread.currentThread().getPriority());
				throw new RuntimeException("unexpected exception");

			}
		});

		thread.setName("dustbin");
		thread.setPriority(Thread.MAX_PRIORITY);
		thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(
						"a critical error happend in thread " + t.getName() + " the error is " + e.getMessage());

			}

		});
		System.out.println("inside thread " + Thread.currentThread().getName());
		thread.start();
	}

}
