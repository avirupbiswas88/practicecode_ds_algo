package com.dustbin.practice.datastructure.stack;

import java.util.Stack;

public class ReverseLinkedListStackImpl {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	void add(int data) {

		Node newNode = new Node(data);

		if (this.head == null) {
			this.head = newNode;
		} else {
			Node currentNode = this.head;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
		}
	}

	void printList(Node node) {

		if (node != null) {
			System.out.print(node.data + " ");
			printList(node.next);
		}
	}

	void reverseList() {
		Stack<Node> stack = new Stack<>();
		Node head = this.head;
		//first pull all node addresses into stack
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		//then traverse the stack and pop nodes
		Node temp = stack.peek();
		this.head = temp;
		stack.pop();
		while (!stack.isEmpty()) {
			temp.next = stack.peek();
			temp = temp.next;
			stack.pop();
		}
		temp.next = null;

	}

	public static void main(String[] args) {

		ReverseLinkedListStackImpl list = new ReverseLinkedListStackImpl();
		list.add(3);
		list.add(5);
		list.add(7);
		list.add(9);
		list.add(11);
		list.add(13);

		list.printList(list.head);
		list.reverseList();
		System.out.println();
		list.printList(list.head);

	}

}
