public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
    	String str = "";
        if(strs.length==0) return str;
        
        StringBuilder sb = new StringBuilder();
        int shortl = strs[0].length(), shorti = 0;
        for(int i=0; i<strs.length; i++){
        	if(strs[i].length()<shortl){
        		shortl = strs[i].length();
        		shorti = i;
        	}
        }
        
        for(int i=0; i<shortl; i++){
        	boolean sig = true;
        	sb.append(strs[shorti].charAt(i));
        	for(int j=0; j<strs.length; j++){
        		if(strs[j].startsWith(sb.toString()) ){
        			
        		}
        		else{
        			sig = false;
        			break;
        		}
        	}
        	if(sig == false){
        		break;
        	}
        	else{
        		str = sb.toString();
        	}
        }
        return str;
    }
    
    public static void main(String[] args){
    	LongestCommonPrefix obj = new LongestCommonPrefix();
    	String[] strs = {"flower","flow","flight"};
    	//String[] strs = {"dog","racecar","car"};
    	//String[] strs = {""};
    	System.out.println("LongestCommonPrefix: "+obj.longestCommonPrefix(strs));
    }
}
