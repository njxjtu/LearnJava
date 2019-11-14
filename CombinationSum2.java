package LearnJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
*/
public class CombinationSum2 {
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	List<List<Integer>> setOfList = new ArrayList<List<Integer>>();
    	
    	if(candidates.length==0){
    		return setOfList;
    	}
    	else if(candidates.length==1 && candidates[0]==target){
    			List<Integer> tempList = new ArrayList<Integer>();
    			tempList.add(candidates[0]);
    			setOfList.add(tempList);
    	}
    	else if(candidates.length>1){
    		Arrays.sort(candidates); //2, 3
    		for(int k=0; k<candidates.length;k++){
    			System.out.print(candidates[k]+", ");
    		}
    		System.out.println(" ");
    		int pos = 0, pos2=0, sum=0;
    		while(pos<candidates.length){
    			List<List<Integer>> tempSetOfList = new ArrayList<List<Integer>>();
    			List<Integer> tempList = new ArrayList<Integer>();

    			pos2 = pos;
    			while(pos2<candidates.length && candidates[pos2]==candidates[pos]){
    				pos2++;
    			}
    			int[] tempcandi = Arrays.copyOfRange(candidates, pos2, candidates.length);
    			System.out.println("tempcandi: ");
    			for(int k=0; k<tempcandi.length;k++){
        			System.out.print(tempcandi[k]+", ");
        		}
        		System.out.println(" ");
    			System.out.println("pos: "+pos+" pos2: "+pos2);
    			while(pos<pos2){
    				System.out.println("in while of pos<pos2");
    				tempSetOfList = combinationSum2(tempcandi, target-sum);
    				if(tempSetOfList.isEmpty()){
        				System.out.println("tempSetOfList is empty - 1");
        			}
    				else{
    					for(List<Integer> tli : tempSetOfList){
            				tli.addAll(tempList);
            				setOfList.add(tli);
            			}
    				}
    				
    				tempList.add(candidates[pos]);
        			sum = sum + candidates[pos];
        			tempSetOfList = combinationSum2(tempcandi, target-sum);
        			if(tempSetOfList.isEmpty()){
        				System.out.println("tempSetOfList is empty - 2");
        				tempList.add(candidates[pos]);
        			}
        			else{
        				for(List<Integer> tli : tempSetOfList){
        					System.out.println("In the second for loop");
            				tli.addAll(tempList);
            				setOfList.add(tli);
            			}
        			}
        			if(tempSetOfList.isEmpty() && target==candidates[pos]){
        				tempList.add(candidates[pos]); 
        				setOfList.add(tempList);
        				break;
        			}
    				
        			pos++;
    			}
    			setOfList.add(tempList);
    			pos++;
    		}
    		
    	}
    	return setOfList;
    }	

    public static void main(String[] args){
    	CombinationSum2 obj = new CombinationSum2();
    	List<List<Integer>> setOfList = new ArrayList<List<Integer>>();
    	int[] candidates = {2,2};
    	int target = 4;
    	setOfList = obj.combinationSum2(candidates, target);
    	for(List<Integer> li : setOfList){
    		for(int i : li){
    			System.out.print(i+", ");
    		}
    		System.out.println(" ");
    	}
    }
}
