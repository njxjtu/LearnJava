package LearnJava;

import java.util.Arrays;

/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example:
Your input
[5,7,7,8,8,10]
8
Expected
[3,4]
 */
public class FirstLastPositionInSortedArray {
    public int[] searchRange(int[] nums, int target) {

    	int ki=-1, kj=-1;
        int[] rarr = {ki, kj};
        if(nums.length==0 || target<nums[0] || target>nums[nums.length-1]) return rarr;
        
        for(int i=0; i<nums.length; i++){
        	if(target==nums[i] && ki==-1){
        		ki=i;
        	}
        	if(kj==-1 && ki!=-1){kj = ki;}
        	if(target==nums[i] && kj!=-1 && i>kj){
        		kj = i;
        	}
        }
        
        rarr[0]=ki;
        rarr[1]=kj;
        return rarr;
    }
    
    public static void main(String[] args){
    	FirstLastPositionInSortedArray obj = new FirstLastPositionInSortedArray();
    	int[] nums = {5,7,7,8,8,10};
    	int target = 8;
    	System.out.println(Arrays.toString(obj.searchRange(nums, target)));
    }
}
