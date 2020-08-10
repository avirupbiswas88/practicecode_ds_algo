package com.dustbin.practice.algorithms;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {

		try {
			int[] array = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 85, 90 };
			//int[] array = { 5 };
			int arrayLength = array.length;
			int keyElement = 100;
			System.out.println("searched element is at "+searchKeyRecursive(array, keyElement, 0, arrayLength-1));
			//System.out.println("searched element is at "+searchKeyLoop(array, keyElement, 0, arrayLength-1));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	private static int searchKeyRecursive(int[] array, int keyElement, int start, int end) throws Exception {
		
		if(start == end) {
			if(keyElement == array[start]) {
				return start;
			}else {
				throw new Exception("element not found");
			}
		}
		
		System.out.println("start index- "+start+" end index- "+end);
		int middleIndex = (start+end)/2;
		if (start > end)
			throw new Exception("element not found");
		System.out.println("middleIndex- "+middleIndex);
		if(array[middleIndex] == keyElement) {
			return middleIndex;
		}else if(keyElement > array[middleIndex]) {
			return searchKeyRecursive(array,keyElement,(middleIndex+1),end);
		}else if(keyElement < array[middleIndex]) {
			return searchKeyRecursive(array,keyElement,start,(middleIndex-1));
		}
		return 0;
	}
	
	private static int searchKeyLoop(int[] array, int keyElement, int start, int end) throws Exception {
		int middleIndex =0;
		while(start <= end) {
			middleIndex =(start+end)/2;
			if(keyElement == array[middleIndex]) {
				return middleIndex;
			}else if(keyElement > array[middleIndex]) {
				start=middleIndex+1;
			}else if(keyElement < array[middleIndex]){
				end=middleIndex-1;
			}
			if (start > end)
				throw new Exception("element not found");
		}
		return middleIndex;
	}

}
