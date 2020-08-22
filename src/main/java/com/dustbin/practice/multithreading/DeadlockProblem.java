package com.dustbin.practice.multithreading;

public class DeadlockProblem {

	private Object key1 = new Object();
	private Object key2 = new Object();

	public void method01() {
		synchronized (key1) {
			System.out.println("[" + Thread.currentThread().getName() + "] I am in method01()");
			method02();
		}
	}

	public void method02() {
		synchronized (key2) {
			System.out.println("[" + Thread.currentThread().getName() + "] I am in method02()");
			method03();
		}
	}

	public void method03() {
		synchronized (key1) {
			System.out.println("[" + Thread.currentThread().getName() + "] I am in method03()");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		DeadlockProblem deadlock = new DeadlockProblem();

		Runnable r1 = () -> {
			deadlock.method01();
		};

		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				deadlock.method02();
			}
		};

		Thread t1 = new Thread(r1);
		t1.start();
		Thread t2 = new Thread(r2);
		t2.start();
		
		t1.join();
		t2.join();

	}

}
