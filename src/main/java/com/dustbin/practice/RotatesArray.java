package com.dustbin.practice;

import java.util.Arrays;

public class RotatesArray {
	
	public static void rotate(int[] nums, int k,int[] numss) {
        
        for(int i=0;i<nums.length;i++){
        	int next= (i+k)%nums.length;
            	numss[next] = nums[i];
            }
    }
	
	public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
        	System.out.println("inside loop");
            int current = start;
            int prev = nums[start];
            do {
            	System.out.println("inside do while");
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6};
	//	int[] newNums = new int[nums.length];
		System.out.println(Arrays.toString(nums));
		rotate(nums,3);
	//	rotate(nums,3,newNums);
		System.out.println(Arrays.toString(nums));

	}

}
