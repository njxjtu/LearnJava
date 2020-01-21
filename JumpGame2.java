package LearnJava;

import java.util.Arrays;

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
Note:

You can assume that you can always reach the last index.
 */
public class JumpGame2 {
    /*public int jump(int[] nums) {
    	if(nums.length<=1){
    		return 0;
    	}
    	else{
    		int maxc =nums.length-1;
            for(int i=1; i<=nums[0] && i<nums.length; i++){
            	int restjump = jump(Arrays.copyOfRange(nums,i,nums.length));
            	if(1+restjump<=maxc){
            		maxc = 1+restjump;
            	};
            }
            return maxc;
    	}
        
    }*/
	
	public int jump(int[] nums) {
		int maxc=nums.length, tablen = nums.length; 
		
    	boolean tab[][] = new boolean[nums.length][nums.length];
    	//set the tab table to false in every cell
    	for(int i=0; i<tablen; i++){
    		for(int j=0; j<tablen; j++){
    			tab[i][j]=false;
    		}
    	}
    	for(int i=0; i<tablen; i++){
    		for(int j=i+1; j<=i+nums[i] && j<tablen; j++){
    			tab[i][j]=true;
    		}
    	}	
    	for(int i=0; i<tablen; i++){
    		if(tab[i][tablen-1]){
    			return i+1;
    		}
    	}
        return maxc;
    }
    
  public static void main(String[] args){
	  //int[] nums = {2,3,1,1,4};
	  int[] nums = {2,3,1,1};
	  //int[] nums = {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
	  JumpGame2 obj = new JumpGame2();
	  System.out.println("array length: "+nums.length+" jump number: "+obj.jump(nums));
  }
}
