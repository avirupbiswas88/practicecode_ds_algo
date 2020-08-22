package com.dustbin.practice.multithreading.waitnotify;

public class ProducerConsumer {

	private static int[] buffer;
	private static int counter;
	private static Object lock = new Object();

	static class Producer {
		void produce() {
			synchronized (lock) {
				if (isFull(buffer)) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				buffer[counter++] = 1;
				lock.notify();
			}
		}
	}

	static class Consumer {
		void consume() {
			synchronized (lock) {
				if (isEmpty(buffer)) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				buffer[--counter] = 0;
				lock.notify();
			}
		}
	}

	static boolean isEmpty(int[] buffer) {
		return counter == 0;
	}

	static boolean isFull(int[] buffer) {
		return counter == buffer.length;
	}

	public static void main(String[] args) throws InterruptedException {

		buffer = new int[10];
		counter = 0;

		Producer producer = new Producer();
		Consumer consumer = new Consumer();

		Runnable r1 = () -> {
			for (int i = 0; i < 50; i++) {
				producer.produce();
			}
			System.out.println("producing completed");
		};

		Runnable r2 = () -> {
			for (int i = 0; i < 40; i++) {
				consumer.consume();
			}
			System.out.println("consuming completed");
		};

		Thread producerThread = new Thread(r1);
		Thread consumerThread = new Thread(r2);
		producerThread.start();
		consumerThread.start();

		producerThread.join();
		consumerThread.join();

		System.out.println("data in the buffer- " + counter);

	}

}
