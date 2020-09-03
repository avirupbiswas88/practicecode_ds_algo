package com.dustbin.practice.multithreading.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

public class LockFreeStackImpl {

	public static void main(String[] args) throws InterruptedException {

		//StandardStack<Integer> stack = new StandardStack<>();
		LockFreeStack<Integer> stack = new LockFreeStack<>();
		Random random = new Random();

		for (int i = 0; i < 100000; i++) {
			stack.push(random.nextInt());
		}
		
		System.out.println(String.format("%,d operations were performed initialy ", stack.getCounter()));

		List<Thread> threads = new ArrayList<>();

		int pushingThreads = 2;
		int poppingThreads = 2;

		for (int i = 0; i < pushingThreads; i++) {
			Thread thread = new Thread(() -> {
				while (true) {
					stack.push(random.nextInt());
				}
			});

			thread.setDaemon(true);
			threads.add(thread);
		}

		for (int i = 0; i < poppingThreads; i++) {
			Thread thread = new Thread(() -> {
				while (true) {
					stack.pop();
				}
			});

			thread.setDaemon(true);
			threads.add(thread);
		}

		for (Thread thread : threads) {
			thread.start();
		}

		Thread.sleep(10000);

		System.out.println(String.format("%,d operations were performed in 10 seconds ", stack.getCounter()));

	}

	private static class Node<T> {
		public T data;
		public Node<T> next;

		Node(T data) {
			this.data = data;
		}
	}

	public static class LockFreeStack<T> {
		private AtomicReference<Node<T>> head = new AtomicReference<>();
		private AtomicInteger counter = new AtomicInteger(0);

		public void push(T data) {

			Node<T> newNode = new Node<T>(data);
			while (true) {
				Node<T> currentHead = head.get();
				newNode.next = currentHead;
				if (head.compareAndSet(currentHead, newNode)) {
					break;
				} else {
					LockSupport.parkNanos(1);
				}
			}

			counter.incrementAndGet();

		}

		public T pop() {

			Node<T> currentHead = head.get();
			Node<T> newHead;

			while (currentHead != null) {
				newHead = currentHead.next;
				if (head.compareAndSet(currentHead, newHead)) {
					break;
				} else {
					LockSupport.parkNanos(1);
					currentHead = head.get();
				}
			}

			counter.incrementAndGet();
			return currentHead != null ? currentHead.data : null;

		}

		public int getCounter() {
			return counter.get();
		}
	}

	public static class StandardStack<T> {
		private Node<T> head;
		private int counter = 0;

		public synchronized void push(T value) {
			Node<T> newHead = new Node<>(value);
			newHead.next = head;
			head = newHead;
			counter++;
		}

		public synchronized T pop() {
			if (head == null) {
				counter++;
				return null;
			}

			T value = head.data;
			head = head.next;
			counter++;
			return value;
		}

		public int getCounter() {
			return counter;
		}
	}
}
