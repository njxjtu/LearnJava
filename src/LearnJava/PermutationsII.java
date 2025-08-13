package LearnJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
	*/	
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
    	List<List<Integer>> lli = new ArrayList<List<Integer>>();
    	Arrays.sort(nums);

    	if(nums.length<=1){
    		List<Integer> li = new ArrayList<Integer>();
    		if(nums.length==1){
    			li.add(nums[0]);
    			lli.add(li);
        		return lli;
    		}
    		else{
    			lli.add(li);
        		return lli;
    		}
    		
        }
    	if(nums.length==2){
    		
    		if(nums[0]==nums[1]){
    			List<Integer> li = new ArrayList<Integer>();
    			li.add(nums[0]);
    			li.add(nums[1]);
    			lli.add(li);
        		return lli;
    		}
    		else{
    			List<Integer> li = new ArrayList<Integer>();
    			li.add(nums[0]);
    			li.add(nums[1]);
    			lli.add(li);
    			List<Integer> li2 = new ArrayList<Integer>();
    			li2.add(nums[1]);
    			li2.add(nums[0]);
    			lli.add(li2);
        		return lli;
    		}
    	}
    	if(nums.length>2){
    		int i=0;
    		while(i<nums.length){
    			if(i+1<nums.length && nums[i]==nums[i+1]){
    				i++;
    				continue;
    			}
    			else if(i<nums.length){
    				int[] temparr = new int[nums.length-1];
        			int j=0;
            		for(int k=0; k<nums.length; k++){
            			if(k!=i){
            				temparr[j]=nums[k];
            				j++;
            			}
            			else{
            				continue;
            			}
            		}
            		List<List<Integer>> templli = permuteUnique(temparr);
            		for(List<Integer> x : templli){
            			x.add(nums[i]);
            			lli.add(x);
            		}
    			}
    			
    			i++;
        	}
    	}
    	
    	return lli;
    }
    
    public static void main(String[] args){
    	PermutationsII obj = new PermutationsII();
    	int[] nums = {1,1,2};
    	//int[] nums = {};
    	List<List<Integer>> rlli =  obj.permuteUnique(nums);
    	for(int i=0; i<rlli.size(); i++){
    		System.out.println("");
    		for(int j=0; j<nums.length; j++){
    			System.out.print(rlli.get(i).get(j)+", ");
    		}
    	}
    	
    }
    
}
