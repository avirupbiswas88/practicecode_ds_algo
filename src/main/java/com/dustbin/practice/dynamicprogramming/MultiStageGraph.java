package com.dustbin.practice.dynamicprogramming;

import java.util.Arrays;

public class MultiStageGraph {
	
	private static int[][] array = {{0,0,0,0,0,0,0,0,0},
	 		{0,0,2,1,3,0,0,0,0},
			{0,0,0,0,0,2,3,0,0},
			{0,0,0,0,0,6,7,0,0},
			{0,0,0,0,0,6,8,9,0},
			{0,0,0,0,0,0,0,0,6},
			{0,0,0,0,0,0,0,0,4},
			{0,0,0,0,0,0,0,0,5},
			{0,0,0,0,0,0,0,0,0}};
	
	private static int[] shortestPath(int[] cost, int[] d, int[] path) {

		int costArrayLastIndex = cost.length - 1;
		cost[costArrayLastIndex] = 0;
		d[costArrayLastIndex] = costArrayLastIndex;

		for (int i = costArrayLastIndex - 1; i >= 1; i--) {
			
			int minWeight = Integer.MAX_VALUE;

			for (int k = i + 1; k <= costArrayLastIndex; k++) {
				if (array[i][k] != 0 && (array[i][k] + cost[k]) < minWeight) {

					minWeight = array[i][k] + cost[k];
					d[i] = k;
				}
			}
			cost[i] = minWeight;
		}
		
		System.out.println(Arrays.toString(cost));
		System.out.println(Arrays.toString(d));

		int pathArrayLength = path.length;
		path[1] = 1;
		path[pathArrayLength - 1] = costArrayLastIndex;
		for (int i = 2; i < pathArrayLength; i++) {
			path[i] = d[path[i - 1]];
		}

		return path;
	}

	public static void main(String[] args) {

		// int[][] array = new int[9][9];

		int stage = 4, n = 8;
		int[] cost = new int[n + 1];
		int[] d = new int[n + 1];
		int[] path = new int[stage + 1];

		System.out.println("shortest path is- " + Arrays.toString(shortestPath(cost, d, path)));

	}

}
