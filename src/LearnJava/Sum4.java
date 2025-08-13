package LearnJava;
import java.util.*;

/*
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

Example: Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */
public class Sum4 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> llir = new ArrayList<List<Integer>>();
        Arrays.sort(nums); // [-2, -1, 0, 0, 1, 2]
        llir = kSum(nums, 4, target);
        
        return llir;
    }
    
    List<List<Integer>> kSum(int[] nums, int k, int target){
    	List<List<Integer>> lli = new ArrayList<List<Integer>>();
    	if(k<=0) return lli;
    	else if(k==1){
    		int i=0;
    		while(i<nums.length){
    			if(nums[i]==target){
    				List<Integer> temp = new ArrayList<Integer>();
    				temp.add(nums[i]);
    				lli.add(temp);
    				while(i+1<nums.length && nums[i+1]==nums[i]){
    					i++;
    				}
    			}
    			i++;
    		}
    	}
    	else if(k==2){
    		int i=0, j=nums.length-1;

	    	while(i<j){
	    		if(nums[i]+nums[j]==target){
	    			List<Integer> temp = new ArrayList<Integer>();
	    			temp.add(nums[i]);
	    			temp.add(nums[j]);
	    			lli.add(temp);
	    			while(i+1<nums.length && nums[i]==nums[i+1])i++;
		    		while(j-1>=i && nums[j]==nums[j-1])j--;
	    			i++; j--;
	    		}
	    		else if(nums[i]+nums[j]<target)i++;
	    		else if(nums[i]+nums[j]>target)j--;
	    	}
    	}
    	else{
    		int i=0;
    		while(i<nums.length){
    			List<List<Integer>> temp_lli = new ArrayList<List<Integer>>();
    			int[] temp_nums = Arrays.copyOfRange(nums, i+1, nums.length);
    			temp_lli = kSum(temp_nums, k-1, target-nums[i]);
    			for(List<Integer> temp_li : temp_lli){
    				temp_li.add(0, nums[i]);
    			}
    			lli.addAll(temp_lli);
    			while(i+1<nums.length && nums[i]==nums[i+1]) i++;
    			i++;
    		}
    	}
    	return lli;
    }
}
