package LearnJava;
import java.util.Stack;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:
Input: "()"
Output: true

Example 2:
Input: "()[]{}"
Output: true

Example 3:
Input: "(]"
Output: false

Example 4:
Input: "([)]"
Output: false

Example 5:
Input: "{[]}"
Output: true

 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> sta = new Stack<Character>();
        boolean r = true;
        for(int i=0; i<s.length(); i++){
        	if(!sta.isEmpty()){
        		if(isPair(sta.peek(),s.charAt(i))){
        			sta.pop();
        		}
        		else if(isLeft(s.charAt(i))){
        			sta.push(s.charAt(i));
        		}
        		else if(!isLeft(s.charAt(i))){
        			return false;
        		}
        	}
        	else {
        		sta.add(s.charAt(i));
        	}
        	
        }
        if(sta.isEmpty()) r = true;
        else r = false;
        
        return r;
    }
    
    boolean isPair(Character c1, Character c2){
    	if(c1.equals('(') && c2.equals(')') || c1.equals('[') && c2.equals(']') || c1.equals('{') && c2.equals('}')){
    		return true;
    	}
    	else return false;
    }
    boolean isLeft(Character c1){
    	if(c1.equals('(') || c1.equals('[') || c1.equals('{')){
    		return true;
    	}
    	else return false;
    }
    
    public static void main(String[] args){
    	ValidParentheses obj = new ValidParentheses();
    	System.out.println(obj.isValid(""));
    }
}
