public class ZigZagConversion {

    public String convert(String s, int numRows) {
    	if(numRows==1) return s;
    	StringBuilder str  = new StringBuilder(); 
    	for(int r=0; r<numRows; r++){   // row index
    		//System.out.println(" r: "+r);
    		if(r==0){
    			for(int i=0; i<s.length(); i=i+2*(numRows-1)){
    	    		str.append(s.charAt(i));
    	    	}
    			//System.out.println(" r=0, str: "+str.toString());
    		}
    		///
    		if(r!=0 && r!=numRows-1){
	    		for(int i=r; i<s.length(); i=i+2*(numRows-1)){
	    			//System.out.println("i: "+i+" i+(numRows-r-1)*2: "+i+(numRows-r-1)*2);
	    			str.append(s.charAt(i));
	    			if(i+(numRows-r-1)*2 < s.length()){
	    				str.append(s.charAt(i+(numRows-r-1)*2));
	    			}
	    			
	    		}
	    		//System.out.println(" r!=0, str: "+str.toString());
    		}
    		///
    		if(r==numRows-1){
    			for(int i=numRows-1; i<s.length(); i=i+2*(numRows-1)){
    	    		str.append(s.charAt(i));
    	    	}
    			//System.out.println(" r=numRows-1, str: "+str.toString());
    		}
	    	
    	}
    	return str.toString();
    }
    
    public static void main(String[] args){
    	ZigZagConversion obj = new ZigZagConversion();
    	//System.out.println(obj.convert("ABCDEFGHIJK", 5));
    	//System.out.println(obj.convert("PAYPALISHIRING", 3));
    	System.out.println(obj.convert("A", 1));
    }
    }
