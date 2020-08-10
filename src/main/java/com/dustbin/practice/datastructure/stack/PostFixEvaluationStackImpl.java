package com.dustbin.practice.datastructure.stack;

import java.util.Stack;

public class PostFixEvaluationStackImpl {

	static int evaluatePostfix(String exp) {

		Stack<Integer> stack = new Stack<>();
		int op1;
		int op2;
		int result;

		for (int i = 0; i < exp.length(); i++) {
			if (exp.charAt(i) == '*' || exp.charAt(i) == '/' || exp.charAt(i) == '+' || exp.charAt(i) == '-') {
				op2 = stack.peek();
				stack.pop();
				op1 = stack.peek();
				stack.pop();
				System.out.println("op1 " + op1);
				System.out.println("op2 " + op2);
				result = perform(exp.charAt(i), op1, op2);
				System.out.println("result for operand " + op1 + "," + op2 + " is- " + result);
				stack.push(result);
			} else {
				stack.push(Integer.parseInt(String.valueOf(exp.charAt(i))));
			}
		}

		return stack.peek();
	}

	static int perform(char operator, int operand1, int operand2) {
		switch (operator) {
		case '+':
			return operand1 + operand2;
		case '-':
			return operand1 - operand2;
		case '*':
			return operand1 * operand2;
		case '/':
			return operand1 / operand2;
		default:
			return 0;

		}
	}

	public static void main(String[] args) {

		String exp = "23*54*+9-";
		System.out.println(evaluatePostfix(exp));

	}

}
