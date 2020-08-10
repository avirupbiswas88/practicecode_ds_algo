package com.dustbin.practice.datastructure.linkedlist;

public class LinkedList {

	Node head;

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static void insert(LinkedList list, int data) {

		// Node newNode = new Node(data); incase Node is a static nested class
		LinkedList.Node newNode = list.new Node(data);
		// System.out.println(newNode.hashCode());

		if (list.head == null) {
			list.head = newNode;
		} else {
			Node temp = list.head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	public static void reverseInsert(LinkedList list, int data) {

		Node listHead = list.head;
		// Node newNode = new Node(data); incase Node is a static nested class
		LinkedList.Node newNode = list.new Node(data);
		if (listHead == null) {
			list.head = newNode;
		} else {
			newNode.next = listHead;
			list.head = newNode;
		}
	}

	public static void display(LinkedList list) {

		if (list.head == null) {
			System.out.println("Empty List");
		} else {
			Node temp = list.head;
			StringBuilder output = new StringBuilder();
			while (temp.next != null) {
				output.append(temp.data + " -> ");
				temp = temp.next;
			}
			output.append(temp.data + " -> NULL");
			System.out.println(output);
		}

	}

	// print linked list data with recursion
	public static void displayWithRecursion(Node head) {
		if (head != null) {
			// System.out.print(head.data + " "); //print in normal order
			displayWithRecursion(head.next);
			System.out.print(head.data + " "); // print in reverse order
		}
		// System.out.println();
	}

	public static void insertAtPosition(LinkedList list, int data, int index) {

		// Node newNode = new Node(data); //incase Node is a static nested class
		LinkedList.Node newNode = list.new Node(data);
		// System.out.println(newNode.hashCode());
		try {
			if (list.head == null) {
				System.out.println("List is empty");
			} else {
				Node temp = list.head;
				Node previous = null;
				for (int i = 0; i < index; i++) {
					// if()
					previous = temp;// previous node of indexed position
					temp = temp.next;
				}
				Node temp2 = temp; // current node indexed position
				temp = newNode; // updating new node at desired index position
				temp.next = temp2; // new node pointing address of old node at this index position, Shifting
									// process
				previous.next = newNode; // previous node linked to new node address at desired index
			}
		} catch (Exception e) {
			System.out.println("Invalid Position- " + index);
		}
	}

	// delete based on position inside linked list
	public static void deleteAtPosition(LinkedList list, int position) {

		LinkedList.Node headNode = list.head;
		try {
			if (position == 1) {
				list.head = headNode.next;
			} else {
				LinkedList.Node previousNode = null;
				for (int i = 0; i < position - 1; i++) {
					previousNode = headNode;
					headNode = headNode.next;
				}
				previousNode.next = headNode.next;
			}
		} catch (Exception e) {
			System.out.println("invalid position");
		}
	}

	// delete based on position inside linked list
	public static void deleteAtPositionApproach2(LinkedList list, int position) {

		LinkedList.Node headNode = list.head;
		try {
			if (position == 1) {
				list.head = headNode.next;
			} else {
				LinkedList.Node previousNode = headNode;
				for (int i = 0; i < position - 2; i++) {
					previousNode = previousNode.next;
				}
				previousNode.next = previousNode.next.next;
			}
		} catch (Exception e) {
			System.out.println("invalid position");
		}
	}

	// delete based on node element
	public static void delete(LinkedList list, int data) {

		Node head = list.head;
		Node previous = null;
		if (head.data == data) {
			list.head = head.next;
		} else {
			Node temp = head;
			while (temp.data != data) {
				previous = temp;
				temp = temp.next;
			}
			previous.next = temp.next;
		}
	}

	public static void reverseList(LinkedList list) {
		LinkedList.Node currentNode = list.head;
		LinkedList.Node previousNode = null;
		LinkedList.Node nextNode = null;
		while (currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}
		list.head = previousNode;
	}

	public static void reverseLinkedListWithRecursion(LinkedList list, Node previous, Node current) {
		if (current != null) {
			reverseLinkedListWithRecursion(list, current, current.next);
			// System.out.println(current.data);
			current.next = previous;
		} else {
			list.head = previous;
		}
	}

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		LinkedList listReverse = new LinkedList();

		System.out.println("Insert node at end of the linkdList");
		insert(list, 10);
		insert(list, 5);
		insert(list, 7);
		insert(list, 9);
		insert(list, 43);
		insert(list, 21);
		insert(list, 29);
		// display(list);
		insertAtPosition(list, 3, 2);
		// display(list);
		insertAtPosition(list, 13, 4);
		display(list);
		System.out.println("reverse linkedlist");
		// reverseList(list);
		reverseLinkedListWithRecursion(list, null, list.head);
		display(list);
		// displayWithRecursion(list.head);
		System.out.println();
		// deleteAtPositionApproach2(list,3);
		// display(list);
		// delete(list,5);
		// display(list);

		// System.out.println("Insert node at begining of the linkdList");
		reverseInsert(listReverse, 2);
		reverseInsert(listReverse, 5);
		reverseInsert(listReverse, 9);
		reverseInsert(listReverse, 13);
		// display(listReverse);

	}

}
