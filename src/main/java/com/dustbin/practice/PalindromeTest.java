package com.dustbin.practice;

public class PalindromeTest {

	private static boolean isPalindrome(String str, int len) {

		boolean response = false;
		if(len < 2)
			return true; 
		int strLen = len - 1;
		for (int i = 0; i < len; i++) {
			System.out.println("iterations- " + i);
			System.out.println("strLen- " + strLen);
			if (i < strLen) {
				if (str.charAt(i) == str.charAt(strLen)) {
					strLen--;
					response = true;
				} else {
					break;
				}
			} else if (i == strLen) {
				if (str.charAt(i) == str.charAt(strLen)) {
					response = true;
				} else {
					response = false;
				}
			} else {
				break;
			}
		}

		return response;
	}

	public static void main(String[] args) {
		String str = "a";
		int length = str.length();
		System.out.println("length of string- " + length);
		System.out.println(isPalindrome(str, length));
		
		int[] arr = {1,2};
		int len = arr.length;

	}

}
