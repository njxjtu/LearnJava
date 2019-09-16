
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
    	List<String> lstr_ini = new ArrayList<String>();
    	List<String> lstr = new ArrayList<String>();
    	for(int i=0; i<digits.length(); i++){
            if((digits.charAt(i)>='2' && digits.charAt(i)<='6') || digits.charAt(i)=='8'){
            	lstrlen = lstrlen*3;
            }
            if(digits.charAt(i)=='7' || digits.charAt(i)=='9'){
            	lstrlen = lstrlen*4;
            }
        }
    	        lstr_ini.add("");
    	        lstr_ini.add("");
    	    	lstr_ini.add("abc");
    	    	lstr_ini.add("def");
    	    	lstr_ini.add("ghi");
    	    	lstr_ini.add("jkl");
    	    	lstr_ini.add("mno");
    	    	lstr_ini.add("pqrs");
    	    	lstr_ini.add("tuv");
    	    	lstr_ini.add("wxyz");

    	
    	for(int i=0; i<lstrlen; i++){
    		StringBuilder sb = new StringBuilder();
    		for(int j=0; j<digits.length();j++){
    			int cur_digit = i/posttime(digits,j);
    			if(cur_digit>=lstr_ini.get(digits.charAt(j)-'0').length())cur_digit =cur_digit%lstr_ini.get(digits.charAt(j)-'0').length();
    			sb.append(lstr_ini.get(digits.charAt(j)-'0').charAt(cur_digit));
    		}
    		lstr.add(sb.toString());
    	}
    	return lstr;
    }

    int posttime(String digits, int i){
    	int posttimes=1;
	    	for(int k=i+1; k<digits.length();k++){
	    		if(digits.charAt(k)>='2' && digits.charAt(k)<='6' || digits.charAt(k)=='8'){
	    			posttimes = posttimes*3;
	    		}
	    		if(digits.charAt(k)=='7' || digits.charAt(k)=='9'){
	    			posttimes = posttimes*4;
	    		}
	    	}
    	return posttimes;
    }

    public static void main(String[] args){
    	LetterCombPhoneNum obj = new LetterCombPhoneNum();
    	List<String> lstr = obj.letterCombinations("273");
    	for(String str : lstr){
    		System.out.println(str+", ");
    	}


    }
}
