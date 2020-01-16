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

Example 6:
Input:
s = "a"
p = "a*"
Output = true

Example 7:
Input:
s = "mississippi"
p = "m??*ss*?i*pi"
Output = false

Example 8:
s = "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba"
p = "a*******b"
false

Example 9:
"babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb"
"b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"

Example 10:
""
""
true

Example 11:
""
"*"
true

Example 12:
"ho"
"**ho"
 */
public class WildcardMatching {
/*    public boolean isMatch(String s, String p) {
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<p.length(); i++){
    		if(i-1>=0 && p.charAt(i)=='*' && p.charAt(i-1)=='*'){
    			continue;
    		}
    		else{
    			sb.append(p.charAt(i));
    		}
    	}
    	p = sb.toString();
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
    			if(j>=s.length() && p.charAt(i)!='*'){return false;}
    			if(j==s.length() && p.charAt(i)=='*' && i==p.length()-1){return true;}
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
    				return false; //
    		    }
    			else{
    				return false;
    			}
    		}
    		if(j<s.length() ){return false;}
    		else{return true; }
    		
    	}
        
    }
    
    */
	/* Dynamic Programming */
	public boolean isMatch(String s, String p) {
    	boolean[][] tab = new boolean[s.length()+1][p.length()+1];
    	boolean signal;
    	
    	// s and p are empty
    	if(s.length()==0 && p.length()==0){
    		return true;
    	}
    	
    	//set initial state
    	tab[0][0] = true;
    	if(s.length()>=1){
    		for(int i=1; i<=s.length(); i++){
    			tab[i][0] = false;
    			signal = tab[i][0];
    		}
    	}
    	if(p.length()>=1){
    		if(p.charAt(0)=='*'){
    			tab[0][1] = true;
    			signal = tab[0][1];
        	}
        	else{
        		tab[0][1]=false;
        		signal = tab[0][1];
        	}
    		for(int i=1; i<=p.length(); i++){
    			if(p.charAt(i-1)=='*'){
    				tab[0][i] = tab[0][i-1];
    				signal = tab[0][i];
    			}
    			else{
    				tab[0][i] = false;
    				signal = tab[0][i];
    			}
    		}
    	}
    	
    	//fill the boolean table
    	
    	for(int i=1; i<=s.length(); i++){
    		for(int j=1; j<=p.length(); j++){
    			if(p.charAt(j-1)>='a' && p.charAt(j-1)<='z' && s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
    				tab[i][j]=tab[i-1][j-1];
    				signal = tab[i][j];
    			}
    			else if(p.charAt(j-1)=='*'){
    				tab[i][j]= tab[i][j-1] || tab[i-1][j];
    				signal = tab[i][j];
    			}
    			else{
    				tab[i][j]=false;
    				signal = tab[i][j];
    			}
    		}
    	}
    	
    	/*for(int i=0; i<=s.length();i++){
    		System.out.println("");
    		for(int j=0; j<p.length(); j++){
    			System.out.print(tab[i][j]+", ");
    		}
    	}*/
    	return tab[s.length()][p.length()];
        
    }
	
    public static void main(String[] args){
    	WildcardMatching obj = new WildcardMatching();
    	//System.out.println(obj.isMatch("aa", "a")); //false
    	System.out.println("Result: "+obj.isMatch("aa", "*")); //true
    	System.out.println(obj.isMatch("cb", "?a")); //false
    	System.out.println(obj.isMatch("adceb", "*a*b")); //true
    	System.out.println(obj.isMatch("acdcb", "a*c?b")); //false
    	System.out.println(obj.isMatch("mississippi", "m??*ss*?i*pi")); //false
    	System.out.println(obj.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b")); //false
    	System.out.println(obj.isMatch("babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb", "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a")); //false
    	
    	System.out.println(obj.isMatch("ho", "*ho")); //true
    }
}
