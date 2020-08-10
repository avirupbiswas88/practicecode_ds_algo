package com.dustbin.practice;

public class RemoveDuplicateSortedArray {
	
	public static int removeDuplicates(int[] nums) {
        int uniqueNum= nums[0];
        int counter=1;
        for(int i=0;i<nums.length;i++){
            if(uniqueNum != nums[i]){
                counter++;
                uniqueNum=nums[i];
            }   
        }
        return counter;
    }

	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		System.out.println(removeDuplicates(nums));

	}

}
