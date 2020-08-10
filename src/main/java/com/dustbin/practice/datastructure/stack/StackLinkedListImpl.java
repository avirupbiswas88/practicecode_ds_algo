package com.dustbin.practice.datastructure.stack;

public class StackLinkedListImpl {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	void push(int data) {

		Node newNode = new Node(data);

		if (this.head == null) {
			this.head = newNode;
		} else {
			Node currentHead = this.head;
			this.head = newNode;
			newNode.next = currentHead;
		}

	}

	void pop() {

		if (this.head == null) {
			System.out.println("empty list");
		} else {
			Node currentHead = this.head;
			this.head = currentHead.next;
		}
	}

	void printList(Node head) {

		if (head != null) {
			System.out.print(head.data + " ");
			printList(head.next);
		}

	}

	int top() {
		return this.head.data;
	}

	boolean emptyStack() {
		if (this.head == null) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		StackLinkedListImpl stack = new StackLinkedListImpl();

		System.out.println(stack.emptyStack());

		stack.push(3);
		stack.push(7);
		stack.push(9);
		stack.push(13);
		stack.push(17);
		stack.push(21);
		stack.push(25);

		System.out.println(stack.emptyStack());

		stack.printList(stack.head);
		System.out.println();

		System.out.println(stack.top());

		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println();

		stack.printList(stack.head);
		System.out.println();
		System.out.println(stack.top());

	}

}
