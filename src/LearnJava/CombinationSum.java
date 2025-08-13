package LearnJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */
public class CombinationSum {
     public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> ll = new ArrayList<List<Integer>>();
        if(candidates.length==0) {
        	return ll;
        }
        else if(candidates.length==1){
        	if(target%candidates[0]==0){
        		List<Integer> templi = new ArrayList<Integer>();
        		for(int i=0; i<target/candidates[0]; i++){
        			templi.add(candidates[0]);
        		}
        		ll.add(templi);
        	}
        }
        else {
        	for(int i=0; i<candidates.length;i++) {
            	if(candidates[i]<=target){
            		List<List<Integer>> templl = new ArrayList<List<Integer>>();
            		int[] tempcandi = Arrays.copyOfRange(candidates, i+1, candidates.length);
            		
            		List<Integer> templi = new ArrayList<Integer>();
            		int sum = 0;
            		for(int j=0; j<target/candidates[i]; j++){
            			templi.add(candidates[i]);
            			sum = sum + candidates[i];
            			templl = combinationSum(tempcandi, target-sum);

            			if(templl.isEmpty() && target%candidates[i]==0 && j==target/candidates[i]-1){
            				ll.add(templi);
            			}
            			for(List<Integer> lis : templl){
                			lis.addAll(templi);
                			ll.add(lis);
                		}
            		}
            	}
            }
        }
       
        return ll;
    }
    
    public static void main(String[] args){
    	CombinationSum obj = new CombinationSum();
    	List<List<Integer>> ll = new ArrayList<List<Integer>>();
    	int[] candidates= {2,3,6,7};
    	int target = 7;
    	ll = obj.combinationSum(candidates, target);
    	for(List<Integer> lis : ll){
			for(int i: lis){
				System.out.print(i+", ");
			}
			System.out.println(" ");
		}
    }
}
