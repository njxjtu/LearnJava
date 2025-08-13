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

Example 2:
Input: [5,6,4,4,6,4,6,8,2]
output: 2

Example 3:
input: [2,1,4,2,6,4]
output: 2

Example 4:
[5,9,3,2,1,0,2,3,3,1,0,0]
output: 3

Example 5:
[8,0,8,5,0,1,1,0,9,4,1,5,1,3,8,0,3,2,2,7,1,7,3,4,5,3,6,1,1,6,7,9,7,5,5,9,8,6,9,7,2,2,5,5,5,3,8,0,5,0,9,9,0,3]
output: 8

Example 6:
[5,9,3,2,1,0,2,3,3,1,0,0]
output: 3
 */
public class JumpGame2 {
/*    public int jump(int[] nums) {
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
	   int[] arr = new int[nums.length];
	   for(int i=nums.length-1; i>=0; i--){
		   if(i==nums.length-1){
			   arr[i]=0;
		   }
		   else if(nums.length-2>=0 && i==nums.length-2 && nums[i]>0){
			   arr[i]=1;
		   }
		   else if(nums[i]==0){
			   arr[i]=Integer.MAX_VALUE;
			   continue;
		   }
		   else{
			   int minc =Integer.MAX_VALUE ;

			   for(int j=1; j<=nums[i]; j++){
				   if(i+j<nums.length &&  nums[i+j] != 0 && arr[i+j]< Integer.MAX_VALUE && 1 + arr[i+j] < minc){
					   minc = 1 + arr[i+j];
				   }
				   if(i+j<nums.length &&  arr[i+j] == 0 ){
					   minc = 1 + arr[i+j];
				   }
			   }
			   arr[i] = minc;
		   }
	   }
	   
	   for(int i=0; i<nums.length; i++){
		   System.out.println(arr[i]+", ");
	   }
	   return arr[0];
    }
    
  public static void main(String[] args){
	  //int[] nums = {2,3,1,1,4};
	  //int[] nums = {2,3,1};
	  //int[] nums = {2,1,4,2,6,4};
	  //int[] nums = {2,0,3};
	  //int[] nums = {8,1,0,0};
	  int[] nums = {8,0,8,5,0,1,1,0,9,4,1,5,1,3,8,0,3,2,2,7,1,7,3,4,5,3,6,1,1,6,7,9,7,5,5,9,8,6,9,7,2,2,5,5,5,3,8,0,5,0,9,9,0,3};
	  //int[] nums = {2,1,0,2};
	  //int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
	  JumpGame2 obj = new JumpGame2();
	  
	  int result = obj.jump(nums);
	  System.out.println(" ");
	  System.out.println("array length: "+nums.length+" jump number: "+result);
  }
}
