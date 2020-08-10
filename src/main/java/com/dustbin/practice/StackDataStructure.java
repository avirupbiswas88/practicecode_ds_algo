package com.dustbin.practice;

import java.util.Stack;

public class StackDataStructure extends Stack<Integer>{
	
	Stack<Integer> minStack = new Stack<>();
	
	public void push(int element) {
		
		if(isEmpty() == true) {
			super.push(element);
			minStack.push(element);
		}else {
			super.push(element);
			int minVal = minStack.pop();
			minStack.push(minVal);
			if(element < minVal) 
				minStack.push(element);
		}
			
	}
	
	public Integer pop() {
		int val = super.pop();
		if(val == minStack.peek())
			minStack.pop();
		return val;
	}
	
	public Integer minValue() {
		return minStack.peek();
	}

	public static void main(String[] args) {
		StackDataStructure s1 = new StackDataStructure();
		s1.push(5);
		s1.push(7);
		s1.push(3);
		s1.push(2);
		s1.push(10);
		s1.push(13);
		s1.push(9);
		s1.push(1);
		
		System.out.println(s1);
		System.out.println(s1.minStack);
		System.out.println(s1.minValue());
		
		s1.pop();
		System.out.println(s1);
		System.out.println(s1.minStack);
		System.out.println(s1.minValue());
		
		s1.pop();
		System.out.println(s1);
		System.out.println(s1.minStack);
		System.out.println(s1.minValue());

	}

}
