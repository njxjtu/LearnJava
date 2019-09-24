import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> lstr = new ArrayList<String>();
        List<String> lstr2 = new ArrayList<String>();
        lstr = generateStrings(2*n, n);
        for(String str : lstr){
        	if(correctParentheses(str)){
        		lstr2.add(str);
        	}
        }
        return lstr2;
    }
    
    List<String> generateStrings(int m, int r){
    	List<String> lstr = new ArrayList<String>();
    	if(r==m) {
    		StringBuilder strb = new StringBuilder();
    		for(int i=0; i<m; i++){
    		    strb.append('(');
    		}
    			lstr.add(strb.toString());
    		return lstr;
    	}
    	if(r>m || r<0 || m<1) return lstr;
    	if(r<m){
    		List<String> lstr_temp1 = new ArrayList<String>();
    		List<String> lstr_temp2 = new ArrayList<String>();
    		lstr_temp1 = generateStrings(m-1,r);
    		lstr_temp2 = generateStrings(m-1,r-1);
    		for(String str : lstr_temp1){
        			lstr.add(")"+str);
    		}
    		for(String str : lstr_temp2){
        			lstr.add("("+str);
    		}
    	}
    	return lstr;
    	
    }
    
    boolean correctParentheses(String s){
    	boolean cp ;
    	Stack<Character> sta = new Stack<Character>();

    	for(int i=0; i<s.length(); i++){
    		if(sta.isEmpty()){
    			sta.push(s.charAt(i));
    			continue;
    			}
    		if(!sta.isEmpty()){
    			if(sta.peek().equals('(') && s.charAt(i)==')'){
    				sta.pop();
    				continue;
    			}
    			else{
    				sta.push(s.charAt(i));
    			}
    		}
    	}
    	if(sta.isEmpty()){
    		cp = true;
    	}
    	else {
    		cp = false;
    	}
    	return cp;
    }
    
    public static void main(String[] args){
    	List<String> lstr = new ArrayList<String>();
    	GenerateParentheses obj = new GenerateParentheses();
    	lstr = obj.generateParenthesis(3);
    	for(String str : lstr){
    		System.out.println(str);
    	}
    	
    }
}
