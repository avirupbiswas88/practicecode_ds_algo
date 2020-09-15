package com.dustbin.practice.dynamicprogramming;

public class AllPairShortestPath {

	public static int[][] graph = { { 0, 0, 0, 0, 0 }, { 0, 0, 3, Integer.MAX_VALUE, 7 },
			{ 0, 8, 0, 2, Integer.MAX_VALUE }, { 0, 5, Integer.MAX_VALUE, 0, 1 },
			{ 0, 2, Integer.MAX_VALUE, Integer.MAX_VALUE, 0 } };

	public static void main(String[] args) {

		graph = getAllPairShortestPath(graph);

		/*
		 * for (int i = 1; i < graph.length; i++) { for (int j = 1; j < graph.length;
		 * j++) { System.out.print(graph[i][j] + " "); }
		 * 
		 * System.out.println(); }
		 */

	}

	public static int[][] getAllPairShortestPath(int[][] graph) {

		int length = graph.length;

		for (int k = 1; k < length; k++) {
			for (int i = 1; i < length; i++) {
				for (int j = 1; j < length; j++) {
					graph[i][j] = Math.min((graph[i][j] == Integer.MAX_VALUE ? Integer.MAX_VALUE : graph[i][j]),
							(graph[i][k] == Integer.MAX_VALUE || graph[k][j] == Integer.MAX_VALUE ? Integer.MAX_VALUE
									: graph[i][k] + graph[k][j]));
					System.out.print(graph[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}

		return graph;
	}

}
