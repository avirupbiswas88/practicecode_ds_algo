package com.dustbin.practice;

import java.util.Scanner;

/*Possible hour glass are :
2 3 0  3 0 0   0 0 0  
  1      0       0 
1 1 1  1 1 0   1 0 0 

0 1 0  1 0 0  0 0 0 
  1      1      0  
0 0 2  0 2 4  2 4 4 

1 1 1  1 1 0  1 0 0
  0      2      4
0 0 0  0 0 2  0 2 0*/

public class HourGlassMatrix {
	//static int R=5;
	//static int C=5;
	static int sumFinal = Integer.MIN_VALUE;
	
	public static int maxSum(int [][] mat,int row,int column) {
		if(row<3 && column<3)
			return -1;
		for(int i=0;i<row-2;i++) {
			for(int j=0;j<column-2;j++) {
				int sum = mat[i][j] + mat[i][j+1]+mat[i][j+2]
						+ mat[i+1][j+1]
						+mat[i+2][j]+mat[i+2][j+1]+mat[i+2][j+2];
				//if(sum >sumFinal)
					//sumFinal=sum;
				sumFinal = Math.max(sumFinal, sum);
			}
		}
		return sumFinal;
	}

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		sc.nextInt();
		
		int [][] mat = {{1, 2, 3, 0, 0}, 
                {0, 0, 0, 0, 0}, 
                {2, 1, 4, 0, 0}, 
                {0, 0, 0, 0, 0}, 
                {1, 1, 0, 1, 0}};
		
		System.out.println(mat.length);//row
		System.out.println(mat[0].length);//column
		
		int r= mat.length;
		int c= mat[0].length;
		System.out.println(maxSum(mat,r,c));

	}

}
