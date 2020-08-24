package com.dustbin.practice.multithreading;

public class ThreadWithThreadClassImpl extends Thread {
	
	@Override
	public void run() {
		System.out.println("current thread "+this.getName());
	}

	public static void main(String[] args) {
		
		//Thread thread = new TaskThread1();
        //thread.start(); 
        Thread thread = new Thread(new Task2());
        thread.start();

	}
	
	private static class TaskThread1 extends Thread {
        @Override
        public void run(){
            System.out.println("Hello from new thread");
        }
    }
	
	private static class Task2 implements Runnable {
        @Override
        public void run(){
            System.out.println("Hello from new thread2");
        }
	}

}
