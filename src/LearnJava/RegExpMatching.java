package LearnJava;
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
        	System.out.println("s.charAt(i): "+s.charAt(i));
        	System.out.println("p.charAt(j): "+p.charAt(j));
        	if(p.charAt(j)>='a' && p.charAt(j)<='z' && (j+1)<p.length() && p.charAt(j+1)=='*'){
        		System.out.println("In 1 ");
        			while(i<s.length() && s.charAt(i)==p.charAt(j)) i++; 
        			j=j+2; 
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
        	else if (p.charAt(j)=='.' && (j+1)>=p.length() ){
        		System.out.println("In . 1");
        		if((i+1)==s.length()) return true;
        		else return false;
        	}
        	else if (p.charAt(j)=='.' && (j+1)<p.length() && p.charAt(j+1)>='a' && p.charAt(j+1)<='z' ){
        		System.out.println("In . 2");
        		if((i+1)==s.length()) return false;
        		else if((i+1)<s.length()){
        			i++; j++; continue;
        		};
        	}
        	else if (p.charAt(j)=='.' && (j+1)<p.length() && p.charAt(j+1)=='*'){
        		System.out.println("In . 3");
        		while(i+1<s.length()){
        			if(s.charAt(i)==s.charAt(i+1)){i++;}
        			else break;
        		}
        		i++; j++; continue;
        	}
        	else if (p.charAt(j)=='*' ){
        		System.out.println("In * ");

        			while(i+1<s.length()){
        				if(s.charAt(i)==s.charAt(i+1)){
        					i++;
        				}
        				else break;
        			}
        			i++;j++; continue;

    	    }
        	System.out.println("Outside ");
        	i++;
        	j++;
        }
        
        System.out.println("i: "+i+" j: "+j);
        if(i<s.length() || j<p.length()){return false;}
        
        return true;
    }
    
    public static void main(String[] args){
    	RegExpMatching obj = new RegExpMatching();
    	System.out.println(obj.isMatch("miss","mis*"));
    }
}
