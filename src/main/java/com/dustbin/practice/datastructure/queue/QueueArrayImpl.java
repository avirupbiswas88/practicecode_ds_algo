package com.dustbin.practice.datastructure.queue;

public class QueueArrayImpl {

	static int MAX_SIZE = 5;
	// circular queue implementations
	int[] queue = new int[MAX_SIZE];
	int front;
	int rear;

	QueueArrayImpl() {
		this.front = -1;
		this.rear = -1;
	}

	void enQueue(int value) {

		int queueSize = this.queue.length;

		if ((this.rear + 1) % queueSize == this.front) {
			System.out.println("queue is full");
		} else if (isEmpty()) {
			this.rear = 0;
			this.front = 0;
		} else {
			this.rear = (this.rear + 1) % queueSize;
		}

		this.queue[this.rear] = value;
	}

	void deQueue() {

		int queueSize = this.queue.length;
		if (isEmpty()) {
			System.out.println("queue is empty");
		} else if (this.rear == this.front) {
			this.rear = -1;
			this.front = -1;
		} else {
			this.front = (this.front + 1) % queueSize;
		}
	}

	boolean isEmpty() {

		if (this.rear == -1 && this.front == -1) {
			return true;
		}

		return false;
	}

	int front() {
		return this.queue[this.front];
	}

	void printQueue() {

		if (this.rear >= this.front) {
			for (int i = this.front; i <= this.rear; i++) {
				System.out.print(this.queue[i] + " ");
			}
		} else if (this.rear < this.front) {
			for (int i = this.front; i < this.queue.length; i++) {
				System.out.print(this.queue[i] + " ");
			}
			for (int i = 0; i <= this.rear; i++) {
				System.out.print(this.queue[i] + " ");
			}
		}
	}

	public static void main(String[] args) {

		QueueArrayImpl queueImplObject = new QueueArrayImpl();

		queueImplObject.enQueue(3);
		queueImplObject.enQueue(5);
		queueImplObject.enQueue(7);
		queueImplObject.enQueue(9);
		queueImplObject.enQueue(13);

		queueImplObject.printQueue();

		queueImplObject.deQueue();
		queueImplObject.deQueue();

		System.out.println();

		queueImplObject.printQueue();

		queueImplObject.enQueue(21);
		queueImplObject.enQueue(23);

		System.out.println();

		queueImplObject.printQueue();
		queueImplObject.enQueue(27);

	}

}
