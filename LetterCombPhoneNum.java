import java.util.ArrayList;
import java.util.List;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:
2 - abc
3 - def
4 - ghi
5 - jkl
6 - mno
7 - pqrs
8 - tuv
9 - wxyz

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombPhoneNum {
    public List<String> letterCombinations(String digits) {
    	int lstrlen = 1;
    	List<String> lstr = new ArrayList<String>();
    	for(int i=0; i<digits.length(); i++){
            if((digits.charAt(i)>='2' && digits.charAt(i)<='6') || digits.charAt(i)=='8'){
            	lstrlen = lstrlen*3;
            }
            if(digits.charAt(i)=='7' || digits.charAt(i)=='9'){
            	lstrlen = lstrlen*4;
            }
        }
    	
    	for(int i=0; i<lstrlen; i++){
    		lstr.add("");
    	}
    	System.out.println("lstrlen: "+lstrlen);
    	
	    for(int i=0; i<digits.length();i++){
	    	   if(i==0){
	    		   if(digits.charAt(i)=='2'){
	    			   System.out.println("digits.charAt(i)=='2' ");
	    			   for(int j=0; j<lstrlen; j++){
	    				   System.out.println("j: "+j+" lstrlen/3: "+lstrlen/3);
	    				   if(j<lstrlen/3){
	    					   System.out.println("j: "+j+"lstr.get(j): "+lstr.get(j));
	    					   lstr.set(j,lstr.get(j).concat("a"));
	    					   System.out.println("j: "+j+"lstr.get(j): "+lstr.get(j));
	    					   }
	    				   else if(j>=lstrlen/3 && j<lstrlen*2/3){lstr.set(j,lstr.get(j).concat("b"));}
	    				   else lstr.set(j,lstr.get(j).concat("c"));
	    			   }
	    		   }
	    	   }
	       }
	    return lstr;
    }

    public static void main(String[] args){
    	LetterCombPhoneNum obj = new LetterCombPhoneNum();
    	List<String> lstr = obj.letterCombinations("2");
    	for(String str : lstr){
    		System.out.println(str+", ");
    	}
    }
}
