
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
        List<String> lstr = new ArrayList<String>();
        int strlen = digits.length();
        int lstrlen = 1; 
        if(digits.length()==0){
        	return lstr;
        }
        for(int i=0; i<digits.length(); i++){
            if((digits.charAt(i)>='2' && digits.charAt(i)<='6') || digits.charAt(i)=='8'){
            	lstrlen = lstrlen*3;
            }
            if(digits.charAt(i)=='7' || digits.charAt(i)=='9'){
            	lstrlen = lstrlen*4;
            }
        }
        for(int i=0; i<digits.length(); i++){
        	if(digits.charAt(i)=='2'){
            	lstr.set(i, lstr.get(i).concat("a"));lstr.set(i+1, "b");lstr.set(i+2, "c");
            }
        	if(digits.charAt(i)=='3'){
            	lstr.set(i, "d");lstr.set(i+1, "e");lstr.set(i+2, "f");
            }
        	if(digits.charAt(i)=='4'){
            	lstr.set(i, "g");lstr.set(i+1, "h");lstr.set(i+2, "i");
            }
        	if(digits.charAt(i)=='5'){
            	lstr.set(i, "j");lstr.set(i+1, "k");lstr.set(i+2, "l");
            }
        	if(digits.charAt(i)=='6'){
            	lstr.set(i, "m");lstr.set(i+1, "n");lstr.set(i+2, "o");
            }
        	if(digits.charAt(i)=='7'){
            	lstr.set(i, "p");lstr.set(i+1, "q");lstr.set(i+2, "r");lstr.set(i+3, "s");
            }
        	if(digits.charAt(i)=='8'){
            	lstr.set(i, "t");lstr.set(i+1, "u");lstr.set(i+2, "v");
            }
        	if(digits.charAt(i)=='9'){
            	lstr.set(i, "w");lstr.set(i+1, "x");lstr.set(i+2, "y");lstr.set(i+3, "z");
            }
        }
        return lstr;
    }

    public static void main(String[] args){
    	LetterCombPhoneNum obj = new LetterCombPhoneNum();
    	List<String> lstr = obj.letterCombinations("23");
    	for(String str : lstr){
    		System.out.println(str+", ");
    	}
    }
}
