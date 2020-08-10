package com.dustbin.practice.datastructure.stack;

import java.util.Stack;

public class InfixToPostfixStackImpl {

	static void convertInfixToPostfix(String infixString) {
		StringBuilder postFixString = new StringBuilder();
		Stack<Character> operatorStack = new Stack<>();
		for (int i = 0; i < infixString.length(); i++) {
			if (isOperator(infixString.charAt(i))) {
				while (!operatorStack.isEmpty() && operatorPrecedence(operatorStack.peek(), infixString.charAt(i))
						&& !isOpeningParentheses(operatorStack.peek())) {
					postFixString.append(operatorStack.peek());
					operatorStack.pop();
				}
				operatorStack.push(infixString.charAt(i));
			} else if (isOperand(infixString.charAt(i))) {
				postFixString.append(infixString.charAt(i));
			} else if (isOpeningParentheses(infixString.charAt(i))) {
				operatorStack.push(infixString.charAt(i));
			} else if (isClosingParentheses(infixString.charAt(i))) {

				while (!operatorStack.isEmpty() && !isOpeningParentheses(operatorStack.peek())) {
					postFixString.append(operatorStack.peek());
					operatorStack.pop();
				}
				operatorStack.pop();
			}
		}

		while (!operatorStack.isEmpty()) {
			postFixString.append(operatorStack.peek());
			operatorStack.pop();
		}

		System.out.println("postfix- " + postFixString.toString());
	}

	static boolean operatorPrecedence(char opOnStack, char opLookingAt) {

		int opOnStackWeight = operatorWeight(opOnStack);
		int opLookingAtWeight = operatorWeight(opLookingAt);

		if (opOnStackWeight == opLookingAtWeight) {
			return true;
		} else if (opOnStackWeight > opLookingAtWeight) {
			return true;
		}

		return false;

	}

	static int operatorWeight(char operator) {

		int weight = -1;
		switch (operator) {
		case '+':
		case '-':
			weight = 1;
			break;
		case '*':
		case '/':
			weight = 2;
			break;
		}

		return weight;
	}

	static boolean isOperator(char charAtPosition) {

		if (charAtPosition == '+' || charAtPosition == '-' || charAtPosition == '*' || charAtPosition == '/') {
			return true;
		}

		return false;

	}

	// Function to verify whether a character is english letter or numeric digit.
	// We are assuming in this solution that operand will be a single character
	static boolean isOperand(char charAtPosition) {
		if (charAtPosition >= '0' && charAtPosition <= '9' || charAtPosition >= 'a' && charAtPosition <= 'z'
				|| charAtPosition >= 'A' && charAtPosition <= 'Z')
			return true;
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

	public static void main(String[] args) {

		 String infixString = "A*B-C*D/E";
		//String infixString = "((A+B)*C-D)*E";
		System.out.println("prefix- " + infixString);
		convertInfixToPostfix(infixString);

	}

}
