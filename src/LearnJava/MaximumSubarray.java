package LearnJava;

import java.util.Arrays;
import java.util.InputMismatchException;

/**
Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

 */ 
public class MaximumSubarray {

    /**
     * Finds the contiguous subarray with the largest sum using Kadane's Algorithm.
     * The original implementation was O(n^3) and would be too slow for large inputs.
     * It also had logical errors in how it calculated the sum.
     * This version is O(n) and is the standard, efficient solution.
     *
     * @param nums The input array of integers.
     * @return The sum of the largest subarray.
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; // As per convention for an empty array.
        }

        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // The maximum subarray ending at index i is either the number at i itself,
            // or the number at i combined with the best subarray ending at i-1.
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);

            // The overall maximum is the max of what we've seen so far
            // and the best we can do ending at the current position.
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public int maxSubArray02(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new InputMismatchException(); 
        }

        int l = nums.length;
        int left = 0, right = 0;


        if (l == 1) {
            return nums[0];
        }

        int maxSoFar = nums[0], maxPre = nums[0];
        
        for (int i=1; i<l; i++) {
            if (maxPre<0){
                maxPre = nums[i];
                if(maxPre > maxSoFar) {
                    left = i;
                    right = i;
                    maxSoFar = maxPre;
                }
                else{
                    continue;
                }
            }
            else{
                maxPre += nums[i];
                if(maxPre > maxSoFar) {
                    right = i;
                    maxSoFar = maxPre;
                }
            }

        }

        return maxSoFar;
    }

    public static void main(String args[]){
        MaximumSubarray ms = new MaximumSubarray();
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Input: " + Arrays.toString(nums1) + " -> Max Sum: " + ms.maxSubArray(nums1));
        System.out.println("Input: " + Arrays.toString(nums1) + " -> Max Sum02: " + ms.maxSubArray02(nums1));
        int[] nums2 = {1};
        System.out.println("Input: " + Arrays.toString(nums2) + " -> Max Sum: " + ms.maxSubArray(nums2));
        System.out.println("Input: " + Arrays.toString(nums2) + " -> Max Sum02: " + ms.maxSubArray02(nums2));
        int[] nums3 = {5,4,-1,7,8};
        System.out.println("Input: " + Arrays.toString(nums3) + " -> Max Sum: " + ms.maxSubArray(nums3));
        System.out.println("Input: " + Arrays.toString(nums3) + " -> Max Sum02: " + ms.maxSubArray02(nums3));
        int[] nums4 = {-9,-7,105,234,-190,200};
        System.out.println("Input: " + Arrays.toString(nums4) + " -> Max Sum: " + ms.maxSubArray(nums4));
        System.out.println("Input: " + Arrays.toString(nums4) + " -> Max Sum02: " + ms.maxSubArray02(nums4));
        int[] nums5 = {-9,0,4};
        System.out.println("Input: " + Arrays.toString(nums5) + " -> Max Sum: " + ms.maxSubArray(nums5));
        System.out.println("Input: " + Arrays.toString(nums5) + " -> Max Sum02: " + ms.maxSubArray02(nums5));
    }
    
}
