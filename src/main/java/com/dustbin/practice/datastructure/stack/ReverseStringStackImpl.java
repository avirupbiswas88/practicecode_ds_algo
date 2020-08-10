package com.dustbin.practice.datastructure.stack;

public class ReverseStringStackImpl {

	static String reverse(String name) {
		char[] charArrayName = name.toCharArray();
		char[] reverseCharArray = new char[charArrayName.length];
		int top = charArrayName.length - 1;
		for (int i = 0; i < charArrayName.length; i++) {
			reverseCharArray[i] = charArrayName[top];
			top--;
		}

		return String.valueOf(reverseCharArray);
	}

	public static void main(String[] args) {

		String name = "avirup";
		System.out.println(reverse(name));

	}

}
