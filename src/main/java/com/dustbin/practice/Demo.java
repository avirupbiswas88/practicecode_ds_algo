package com.dustbin.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
	
	Node head;
	
	public static class Node{
		String data;
		Node next;
		
		Node(String d){
			this.data = d;
		}
	}
	
	private static Node createList(Node head,String data) {
		
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
		}else {
			while(head.next != null) {
				head = head.next;
			}
			head.next = newNode;
		}
		
		return newNode;
	}
	
	private static int maxPath(Node head) {
		
		int counter = 0;
		while(head != null) {
			head = head.next;
			counter++;
		}
		return counter;
	}
	
	
	
	
	
	

	/*private static int subArray(int[] array, List<int[]> arrayList, int[] inputArray) {

		int input01 = inputArray[0];
		int input02 = inputArray[1];
		int ip1Counter = 0;
		int ip2Counter = 0;
		for (int i = 0; i < array.length; i++) {
			int size = 0;
			int[] subArray = new int[array.length - i];
			for (int j = i; i < array.length; j++) {

				subArray[size] = array[j];
				for (int k = 0; k < subArray.length; k++) {
					if (subArray[k] % input01 == 0) {
						ip1Counter++;
					}
					if (subArray[k] % input02 == 0) {
						ip2Counter++;
					}
				}
				//System.out.println(Arrays.toString(subArray));
				arrayList.add(subArray);
				size++;
			}
		}

		if (ip1Counter > ip2Counter) {
			return input01;
		} else {
			return input02;
		}

	}*/

	public static void main(String[] args) {

		//int[] array = { 1, 29, 20, 3, 4, 6, 7 };
		//int[] inputArray = { 3, 4 };
		//List<int[]> arrayList = new ArrayList<>();

		//System.out.println(subArray(array, arrayList, inputArray));
		
		int[][] array= new int[5][5];
		
		

	}

}
