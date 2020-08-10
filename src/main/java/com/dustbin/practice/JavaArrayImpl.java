package com.dustbin.practice;

public class JavaArrayImpl {
	
	public int[] myArray = new int[10];
	public int arraySize = 10;
	
	public void generateArray() {
		
		for(int i=0;i<arraySize;i++) {
			myArray[i] = (int) (Math.random()*10) + 10;
		}
		
	}
	
	public void printArray() {
		System.out.println("----------");
		for(int i=0;i<arraySize;i++) {
			System.out.print(i+" | ");
			System.out.println(myArray[i]+" | ");
			System.out.println("----------");
		}
	}
	
	public void deleteIndex(int index) {
		
		if(index < arraySize) {
			for(int i=index;i<arraySize-1;i++) {
				myArray[i] = myArray[i+1];
			}
			myArray[arraySize-1] = 0;
		}
	}
	
	public void bubbleSort() {
		
		for(int i=arraySize-1;i>1;i--) {
			for(int j=0;j<i;j++) {
				if(myArray[j] > myArray[j+1])
					swapElements(j,j+1);
			}
		}
	}
	
	public void selectionSort() {
		for(int i=0;i<arraySize;i++) {
			int min = i;
			for(int j=i;j<arraySize;j++) {
				if(myArray[min] < myArray[j]) {
					min= j;
				}
			}
			swapElements(i,min);
			
		}
	}
	
	public void swapElements(int a,int b) {
		int temp = myArray[a];
		myArray[a] = myArray[b];
		myArray[b] = temp;
	}

	public static void main(String[] args) {
		JavaArrayImpl array = new JavaArrayImpl();
		array.generateArray();
		array.printArray();
		
		System.out.println("=============");
		
		//array.deleteIndex(4);
		//array.printArray();
		//array.bubbleSort();
		array.selectionSort();
		array.printArray();
		
		System.out.print(Math.min(3, 3));

	}

}
