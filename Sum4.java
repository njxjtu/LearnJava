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
    	List<List<Integer>> lli = new ArrayList<List<Integer>>();
    	Set<List<Integer>> sli = new Set<List<Integer>>();
    	if(nums.length<4) return lli;
        Arrays.sort(nums); // [-2, -1, 0, 0, 1, 2]
        int i=0, j=1, k=nums.length-2, q=nums.length-1;
        
        while()
        
        return lli;
    }
}
