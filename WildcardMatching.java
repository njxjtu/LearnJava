class Solution {
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
    		    }
    			else{
    				return false;
    			}
    		}
    		if(j<s.length() ){return false;}
    		else{return true; }
    		
    	}
    }
}
