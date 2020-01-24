package LearnJava;

import java.util.*;

/*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> lli = new ArrayList<List<Integer>>();
    	
    	if(nums.length==0){return lli;}
    	if(nums.length==1){
    		List<Integer> li = new ArrayList<Integer>();
    		li.add(nums[0]);
    		lli.add(li);
    		return lli;
        }
    	else {
    		for(int i=0; i<nums.length; i++){
    			int[] temparr = new int[nums.length-1];
    			int j=0;
        		for(int k=0; k<nums.length; k++){
        			if(nums[k]!=nums[i]){
        				temparr[j]=nums[k];
        				j++;
        			}
        		}
        		lli = permute(temparr);
        		for(List<Integer> x : lli){
        			x.add(nums[i]);
        		}
        	}
    	}
    	
    	return lli;
    }
    
    public static void main(String[] args){
    	Permutation obj = new Permutation();
    	int[] nums = {4,5};
    	List<List<Integer>> rlli =  obj.permute(nums);
    	for(int i=0; i<rlli.size(); i++){
    		System.out.println("");
    		for(int j=0; j<nums.length; j++){
    			System.out.println(rlli.get(i).get(j)+", ");
    		}
    	}
    	
    }
}
