package com.dustbin.practice.dynamicprogramming;


/*
 * Longest Common Subsequences- 
 * str1- stone
 * str2- longest
 * result- one(3) -- longest sub sequence
 * */
public class LongestCommonSubsequences {

	public static int getLcs(String str1, String str2, int[][] lcs) {

		for (int i = 0; i <= str1.length(); i++) {

			for (int j = 0; j <= str2.length(); j++) {
				if (i == 0 || j == 0) {
					lcs[i][j] = 0;
				} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					lcs[i][j] = 1 + lcs[i - 1][j - 1];
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}

				System.out.print(lcs[i][j] + " ");

			}
			System.out.println();
		}

		return lcs[str1.length()][str2.length()];

	}

	public static void main(String[] args) {

		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
		int[][] lcs = new int[str1.length() + 1][str2.length() + 1];
		System.out.println("Length of LCS is- " + getLcs(str1, str2, lcs));
	}

}
