package LearnJava;
/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example:
[1,3]
0

Example:
[1,3,5]
3
Expected output: 1
 */
public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
    
    	if(nums.length==0){return -1;}
    	if(nums.length==1 && nums[0]==target){return 0;}
    	
        int i=0, j=nums.length-1, idx = -1;
        while(i<=j){
        	if(nums[i]>nums[j]){
        		if(target<nums[j]){
        			j--;
        		}
        		else if(target==nums[j]){
        			return j;
        		}
        		else if(target==nums[i]){
        			return i;
        		}
        		else if(target>nums[i]){
        			i++;
        		}
        		else if(target>nums[j] && target<nums[i]){
        			return -1;
        		}
        	}
        	else{
        		if(target==nums[i]){
        			return i;
        		}
        		else if(target>nums[i] && target<nums[j]){
        			i++; j--;
        		}
        		else if(target==nums[j]){
        			return j;
        		}
        		else return -1;
        	}
        }
        
        return idx;
    }
    
    public static void main(String[] args){
    	SearchRotatedSortedArray obj = new SearchRotatedSortedArray();
    	int[] nums = {1,3,5}; 
    	int target = 3;
    	System.out.print(obj.search(nums, target));
    }
}
