/*Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
*/
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int len = nums.length, i=0;
        while(i<len){
        	if(i-1>=0 && nums[i-1]==nums[i]){
        		len--;
        		for(int j=i; j<len; j++){
        			nums[j] = nums[j+1];
        		}
        	}
        	else{
        		i++;
        	}
        }
        return len;
    }
    
    public int removeDuplicates2(int[] nums) {  //faster way
        if(nums.length<=1) return nums.length;
        int len = nums.length, i=0, j=1;
        while(i<len && j<nums.length){
        	if(nums[i]==nums[j]){
        		j++; len--;
        	}
        	else{
        		i++;
        		nums[i]=nums[j];
        		j++;
        	}
        }
        return len;
    }   
}
