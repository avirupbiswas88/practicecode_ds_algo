package com.dustbin.practice.datastructure.stack;

import java.util.Stack;

public class BalancedParenthesesStackImpl {

	static boolean checkBalancedParentheses(String input) {

		Stack<Character> charStack = new Stack<>();
		int len = input.length();
		for (int i = 0; i < len; i++) {
			if (isOpeningParentheses(input.charAt(i))) {
				charStack.push(input.charAt(i));
			} else if (isClosingParentheses(input.charAt(i))) {
				if (charStack.isEmpty() || !isClosingOf(charStack.peek(), input.charAt(i))) {
					return false;
				} else {
					charStack.pop();
				}
			}
		}

		if (charStack.isEmpty()) {
			return true;
		}

		return false;

	}

	static boolean isOpeningParentheses(char charAtPosition) {

		if (charAtPosition == '(' || charAtPosition == '{' || charAtPosition == '[') {
			return true;
		}
		return false;
	}
	
	static boolean isClosingParentheses(char charAtPosition) {

		if (charAtPosition == ')' || charAtPosition == '}' || charAtPosition == ']') {
			return true;
		}
		return false;
	}

	public static boolean isClosingOf(char opening, char closing) {

		if (opening == '(' && closing == ')')
			return true;
		else if (opening == '{' && closing == '}')
			return true;
		else if (opening == '[' && closing == ']')
			return true;

		return false;
	}

	public static void main(String[] args) {

		String value = "{(a+b) * [c+d)}";

		System.out.println(checkBalancedParentheses(value));

	}

}
