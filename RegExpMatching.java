/*
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
*/

public class RegExpMatching {

    public boolean isMatch(String s, String p) {
    	
    	if(s.isEmpty()){
    		if(p == "*") return true;
    		else return false;
    	}
    	if(p.isEmpty()){
    		return false;
    	}
    	int i=0, j=0;
    	
        while(i<s.length() && j<p.length()){
        	if(p.charAt(j)>='a' && p.charAt(j)<='z' && (j+1)<p.length() && p.charAt(j+1)=='*'){
        		if(p.charAt(j)==s.charAt(i)) {
        			i++;
        			while(i<s.length() && s.charAt(i)==p.charAt(j)) i++; 
        			j++; continue;}
        		else return false;
        	}
        	else if (p.charAt(j)>='a' && p.charAt(j)<='z' && (j+1)>=p.length() ){
        		if(p.charAt(j)==s.charAt(i) && i+1 >= s.length()){
        			return true;
        		}
        		else return false;
        	}
        	else if (p.charAt(j)>='a' && p.charAt(j)<='z' && (j+1)<p.length() && p.charAt(j+1)=='.'){
        		if(p.charAt(j)==s.charAt(i) && i+1 < s.length()){
        			i = i+2;
        			continue;
        		}
        		else if(p.charAt(j)!= s.charAt(i)){
        			return false;
        		}
        	}
        	else if (p.charAt(j)>='a' && p.charAt(j)<='z' && (j+1)<p.length() && p.charAt(j+1)>='a' && p.charAt(j+1)<='z'){
        		if(p.charAt(j)==s.charAt(i)){
        			i++; j++;
        			continue;
        		}
        	}
        	else if (p.charAt(j)=='.' ){
        			i++; j++;
        			continue;
        	}
        	else if (p.charAt(j)=='*' ){
        		if(p.charAt(j)==s.charAt(i)){
        			i++; j++;
        			continue;
        		}
    	    }
        }
        
        
        return true;
    }
}
