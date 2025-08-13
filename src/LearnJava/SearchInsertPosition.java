package LearnJava;
/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
    	int pos = -1;
        if(nums.length==0){return 0;}
        for(int i=0; i<nums.length; i++){
        	if(target<nums[i]){
        	    pos = i==0? 0: i;
        		break;
        	}
        	else if(target==nums[i]){
        		pos = i;
        		break;
        	}
        }
        if(pos == -1){
        	pos = nums.length;
        }
        
        return pos;
    }
    
    public static void main(String[] args){
    	int[] nums = {1,3,5,6};
    	int target = 0;
    	SearchInsertPosition obj = new SearchInsertPosition();
    	System.out.println(obj.searchInsert(nums, target));
    	
    }
}
