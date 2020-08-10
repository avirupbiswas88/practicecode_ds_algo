package com.dustbin.practice.datastructure.linkedlist;

public class DoublyLinkedList {

	Node head;

	static class Node {
		int data;
		Node prev;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static void addNode(DoublyLinkedList list, int data) {

		Node newNode = new Node(data);

		if (list.head == null) {
			list.head = newNode;
		} else {
			Node tempNode = list.head;
			while (tempNode.next != null) {
				tempNode = tempNode.next;
			}
			tempNode.next = newNode;
			newNode.prev = tempNode;
		}
	}

	public static void printDoublyLinkedList(Node head) {

		if (head == null) {
			System.out.println("empty list");
		} else {
			while (head != null) {
				System.out.print(head.data + " ");
				head = head.next;
			}
		}
	}

	public static void deleteAtPosition(DoublyLinkedList list, int position) {

		if (list.head == null) {
			System.out.println("empty list");
		} else {
			Node currentNode = list.head;
			// Node previousNode=null;
			for (int i = 0; i < position - 1; i++) {
				// previousNode = currentNode;
				currentNode = currentNode.next;
			}
			// previousNode.next = currentNode.next;
			currentNode.prev.next = currentNode.next;
			currentNode.next.prev = currentNode.prev;
		}
	}

	public static void insertAtPosition(DoublyLinkedList list, int data, int position) {

		Node newNode = new Node(data);

		if (list.head == null) {
			list.head = newNode;
		} else {
			Node currentNode = list.head;
			for (int i = 0; i < position - 1; i++) {
				currentNode = currentNode.next;
			}
			newNode.next = currentNode;
			newNode.prev = currentNode.prev;
			currentNode.prev.next = newNode;
		}

	}

	public static void main(String[] args) {

		DoublyLinkedList list = new DoublyLinkedList();

		addNode(list, 3);
		addNode(list, 7);
		addNode(list, 9);
		addNode(list, 13);
		addNode(list, 17);
		addNode(list, 21);
		addNode(list, 39);

		printDoublyLinkedList(list.head);

		deleteAtPosition(list, 4);
		System.out.println();
		printDoublyLinkedList(list.head);

		insertAtPosition(list, 19, 5);
		System.out.println();
		printDoublyLinkedList(list.head);
	}

}
