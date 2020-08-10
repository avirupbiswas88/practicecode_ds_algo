package com.dustbin.practice.datastructure.queue;

public class QueueLinkedListImpl {

	Node front;
	Node rear;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	void enQueue(int data) {

		Node newNode = new Node(data);
		if (this.front == null && this.rear == null) {
			this.front = this.rear = newNode;
		} else {
			Node currentRear = this.rear;
			currentRear.next = newNode;
			this.rear = newNode;
		}

	}

	void deQueue() {
		if (this.front == null) {
			System.out.println("queue is empty");
		} else if (this.front == this.rear) {
			this.front = this.rear = null;
		} else {
			Node currentFront = this.front;
			this.front = currentFront.next;
		}
	}

	int front() {
		return this.front.data;
	}

	void printQueue() {

		if (this.front == null) {
			System.out.println("queue is empty");
		} else {
			Node temp = this.front;
			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
		}
	}

	public static void main(String[] args) {

		QueueLinkedListImpl queueImplObject = new QueueLinkedListImpl();

		queueImplObject.enQueue(3);
		queueImplObject.deQueue();
		queueImplObject.printQueue();
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
		queueImplObject.enQueue(25);
		queueImplObject.enQueue(31);
		queueImplObject.enQueue(39);
		System.out.println();

		queueImplObject.printQueue();
	}

}
