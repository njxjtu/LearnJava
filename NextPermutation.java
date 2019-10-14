package LearnJava;

import java.util.Arrays;
import java.util.Collections;

/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 -> 1,3,2
3,2,1 -> 1,2,3
1,1,5 -> 1,5,1

Example:
input [1,3,2]
expected output: [2,1,3]

 */
public class NextPermutation {
    /* I'm referencing the algorithm at https://www.nayuki.io/page/next-lexicographical-permutation-algorithm */
    public void nextPermutation(int[] nums) {
    	if(nums.length==0 || nums.length==1){
    		return;
    	}
        int pivot , i=nums.length-1;
        while(i-1>=0 && nums[i]<=nums[i-1]){
        	i--;
        }
        if(i==0){
        	Arrays.sort(nums);
        	return;
        }
        else{
        	pivot = i;
        }
    }
}
