package LearnJava;
/*
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.

Example 1:
Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.

Example 3:
Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

Example 4:
Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".

Example 5:
Input:
s = "acdcb"
p = "a*c?b"
Output: false
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
    	if(s.isEmpty()){
    		if(p.isEmpty() || p.equals("*")){
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	else{
    		int j=0;
    		for(int i=0; i<p.length(); i++){
    			if(j>=s.length()){return false;}
    			if(p.charAt(i)>='a' && p.charAt(i)<='z' && p.charAt(i)==s.charAt(j)){
    				j++;
    				continue;
    			}
    			else if(p.charAt(i)>='a' && p.charAt(i)<='z' && p.charAt(i)!=s.charAt(j)){
    				return false;
    			}
    			else if(p.charAt(i)=='?' && j<s.length()){
    		    	j++; 
    		    	continue;
    		    }
    			else if(p.charAt(i)=='*'){
    				if(isMatch(s.substring(j, s.length()),p.substring(i+1, p.length()))){
    					return true;
    				}
    				while(j<s.length() && s.charAt(j)>='a' && s.charAt(j)<='z' ){
    					if(j==s.length()-1 && i==p.length()-1){
    						return true;
    					}
    					else if(j+1<s.length() && isMatch(s.substring(j+1, s.length()),p.substring(i+1, p.length()))){
        					return true;
        				}
    					else{
    						j++;
    					}
    				}
    		    }
    			else{
    				return false;
    			}
    		}
    		if(j<s.length() ){return false;}
    		else{return true; }
    		
    	}
        
    }
    
    public static void main(String[] args){
    	WildcardMatching obj = new WildcardMatching();
    	System.out.println(obj.isMatch("aa", "a")); //false
    	System.out.println(obj.isMatch("aa", "*")); //true
    	System.out.println(obj.isMatch("cb", "?a")); //false
    	System.out.println(obj.isMatch("adceb", "*a*b")); //true
    	System.out.println(obj.isMatch("acdcb", "a*c?b")); //false
    }
}
