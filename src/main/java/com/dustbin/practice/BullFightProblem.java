package com.dustbin.practice;

import java.util.HashSet;
import java.util.Set;

public class BullFightProblem {

	static void getMatch(String secret, String guess) {

		Set<Character> set = new HashSet<>();
		Set<Character> cowSet = new HashSet<>();
		Set<Character> bullSet = new HashSet<>();

		for (int i = 0; i < secret.length(); i++) {
			set.add(secret.charAt(i));
		}

		for (int i = 0; i < guess.length(); i++) {
			if (guess.charAt(i) == secret.charAt(i)) {
				bullSet.add(guess.charAt(i));
			} else if (guess.charAt(i) != secret.charAt(i) && set.contains(guess.charAt(i))) {
				cowSet.add(guess.charAt(i));
			}
		}

		System.out.println(cowSet.size());
		System.out.println(bullSet.size());
	}

	public static void main(String[] args) {

		String secret = "1345";
		String guess = "0341";

		getMatch(secret, guess);

	}

}
