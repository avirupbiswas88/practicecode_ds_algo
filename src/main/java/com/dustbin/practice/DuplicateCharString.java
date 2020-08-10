package com.dustbin.practice;

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class DuplicateCharString {
	
	public static char getDuplicateChar(String str) {
		
		Set<String> uniqueChar = new LinkedHashSet<>();
		Character dupChar = null;
		for(int i=0;i<str.length();i++) {
			if(!uniqueChar.add(String.valueOf(str.charAt(i)))) {
				dupChar = str.charAt(i);
				break;
			}
		}
		System.out.println(uniqueChar);
		return dupChar;
		
	}

	public static void main(String[] args) {
		
		String str= "avirupp";
		System.out.println(getDuplicateChar(str));

	}

}
