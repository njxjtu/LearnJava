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

Example:
Input
[1,5,1]
Expected
[5,1,1]

Example:
Input
[5,4,7,5,3,2]
Expected
[5,5,2,3,4,7]
 */
public class NextPermutation {
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
        	pivot = i-1;
        }
        i=nums.length-1;
        while(i>pivot && nums[i]<=nums[pivot]){
        	i--;
        }
        if(pivot<i){
        	int tempn = nums[pivot];
            nums[pivot] = nums[i];
            nums[i] = tempn;
            
            for(int j=pivot+1, k=nums.length-1; j<(nums.length+pivot+1)/2 && k>j; j++,k--){
            	tempn = nums[j];
                nums[j] = nums[k];
                nums[k] = tempn;
            }
            
        }
        
        
    }
    
    public static void main(String[] args){
    	NextPermutation obj = new NextPermutation();
    	int[] testarr = {1,3,2};
    	obj.nextPermutation(testarr);
    	System.out.println(Arrays.toString(testarr));
    }
}
