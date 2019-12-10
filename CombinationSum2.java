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
sorted list: [1, 1, 2, 5, 6, 7, 10]
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
    	else if(candidates.length==1){
    		List<Integer> tempList = new ArrayList<Integer>();
    		if(candidates[0]==target){
    			tempList.add(candidates[0]);
    			setOfList.add(tempList);
    		}
    		return setOfList;
    	}
    	else if(candidates.length>1){
    		Arrays.sort(candidates); 
    		int pos = 0, pos2=0, sum=0;
    		
    		while(pos<candidates.length){
    			System.out.println("**********while loop********* " +" pos: "+pos);
    			List<Integer> tempList1 = new ArrayList<Integer>();
    			while(pos2>=pos && pos2<candidates.length && candidates[pos2]==candidates[pos]){
        			pos2++;
        		}
    			System.out.println("pos2: "+pos2);
    			//
    			
    			if(pos-1>=0 && candidates[pos-1]!=candidates[pos]){
    				sum = 0;
    			}
    			System.out.println("Sum: "+sum);
    			List<List<Integer>> tempSetOfList = new ArrayList<List<Integer>>();
    			//
    			if(candidates[pos]+sum<=target){
    				System.out.println("if(candidates[pos]+sum<=target) ");
    				sum = candidates[pos]+sum;
    				System.out.println("In if - Sum: "+sum);
    				tempList1.add(candidates[pos]);

					int[] tempcandi = Arrays.copyOfRange(candidates, pos2, candidates.length);
    				for(int k: tempcandi){System.out.println("k: "+k);}
    				if(tempcandi.length>0){
    					tempSetOfList = combinationSum2(tempcandi, target-sum);
    				}
    				if(tempSetOfList.isEmpty() || (!tempSetOfList.isEmpty() && tempSetOfList.get(0).isEmpty())){
    					System.out.println("tempSetOfList.isEmpty ");
    					if(sum == target ){
    						System.out.println("if(sum == target && pos-1>=0) ");
    						for(int p=pos; p-1>=0 && candidates[p-1]==candidates[p];p--){
    							tempList1.add(candidates[p]);
    						}
    						setOfList.add(tempList1);
    					}
    				}
    				else{
    					System.out.println("tempSetOfList.is not Empty "+tempSetOfList.get(0));
    					
						for(int p=pos; p-1>=0 && candidates[p-1]==candidates[p];p--){
							tempList1.add(candidates[p]);
						}
    					for(List<Integer> tli : tempSetOfList){
    						for(int k: tempList1){System.out.println("each of tempList: "+k);}
        					for(int k: tli){System.out.println("each of tli: "+k);}
            				//tempList1.addAll(tli);
            				tli.addAll(tempList1);
            				for(int k: tli){System.out.println("after add - each of tli: "+k);}
            				setOfList.add(tli);
            				for(List<Integer> li : setOfList){
            		    		for(int i : li){
            		    			System.out.print(i+", ");
            		    		}
            		    		System.out.println(" ");
            		    	}
                		}
    				}
    			}
        		pos++;
    			}
    		System.out.println(" Before returning back ");
    		for(List<Integer> li : setOfList){
	    		for(int i : li){
	    			System.out.print(i+", ");
	    		}
	    		System.out.println(" ");
	    	}
    		}
    	return setOfList;
    }	

    public static void main(String[] args){
    	CombinationSum2 obj = new CombinationSum2();
    	List<List<Integer>> setOfList = new ArrayList<List<Integer>>();
    	int[] candidates = {1,2,3};
    	int target = 3;
    	setOfList = obj.combinationSum2(candidates, target);
    	System.out.println("====================== ");
    	for(List<Integer> li : setOfList){
    		for(int i : li){
    			System.out.print(i+", ");
    		}
    		System.out.println(" ");
    	}
    }
}
