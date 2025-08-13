package LearnJava;

import java.util.Arrays;

/*
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/
public class Sum3Closest {

	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        if(nums.length==0 || nums.length<3) return target;
        
        int closer=nums[0]+nums[1]+nums[2], j, k;
        System.out.println("closer: "+closer);
        for(int i=0; i<nums.length-1;i++){
        	j = i+1; 
        	k = nums.length-1;
        	System.out.println("Outer - i: "+i+" j: "+j+" k: "+k);
        	while(j>i && k>i && j<k && k<= nums.length-1){
        		System.out.println("While - i: "+i+" j: "+j+" k: "+k);
        		System.out.println("Math.abs(nums[i]+nums[j]+nums[k]-target): "+Math.abs(nums[i]+nums[j]+nums[k]-target));
        		if(Math.abs(nums[i]+nums[j]+nums[k]-target)<Math.abs(closer-target)){
        			System.out.println("i: "+i+" j: "+j+" k: "+k);
        			closer = nums[i]+nums[j]+nums[k];
        		}
        		if(nums[i]+nums[j]+nums[k]<target){
        			j++;
        		}
        		else k--;
        	}
        }
        return closer;
    }
	
	public static void main(String[] args){
		Sum3Closest obj = new Sum3Closest();
		int[] input = {-4, -1, 1, 2};
		System.out.println(obj.threeSumClosest(input, 1));
	}
}
