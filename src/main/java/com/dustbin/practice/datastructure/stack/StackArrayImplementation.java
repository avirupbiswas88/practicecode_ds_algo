package com.dustbin.practice.datastructure.stack;

public class StackArrayImplementation {

	static int MAX_SIZE = 100;
	int[] stackArray = new int[MAX_SIZE];
	int top;

	StackArrayImplementation() {
		this.top = -1;
	}

	void push(int data) {
		if (this.top == MAX_SIZE - 1) {
			System.out.println("Error- stack overflow");
		} else {
			this.stackArray[++top] = data;
		}
	}

	void pop() {
		if (this.top == -1) {
			System.out.println("Error- stack is empty");
		} else {
			this.top--;
		}
	}

	boolean isEmpty() {
		if (this.top == -1) {
			return true;
		}
		return false;
	}

	int top() {
		return this.stackArray[this.top];
	}

	void printStack() {
		if (this.top == -1) {
			System.out.println("Error- stack is empty");
		} else {
			for (int i = 0; i <= this.top; i++) {
				System.out.print(this.stackArray[i] + " ");
			}
		}
	}

	public static void main(String[] args) {

		StackArrayImplementation stackArray = new StackArrayImplementation();
		stackArray.push(3);
		stackArray.push(7);
		stackArray.push(9);
		stackArray.push(13);
		stackArray.push(17);
		stackArray.push(21);
		stackArray.push(39);

		System.out.print("top element- " + stackArray.top());
		System.out.println();

		stackArray.printStack();

		stackArray.pop();
		stackArray.push(29);
		System.out.println();
		System.out.print("top element- " + stackArray.top());
		System.out.println();

		stackArray.printStack();

	}

}
