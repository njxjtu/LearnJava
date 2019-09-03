public class RomanToInteger {

    public int romanToInt(String s) {
       int output =0, i=0;
       while(i<s.length()){
    	   if(i+1<s.length()){
    		   if(s.charAt(i)=='I' && s.charAt(i+1)=='V'){
    			   output = output + 4;
    			   i = i + 2;
    			   continue;
    		   }
    		   else if(s.charAt(i)=='I' && s.charAt(i+1)=='X'){
    			   output = output + 9;
    			   i = i + 2;
    			   continue;
    		   }
    		   else if(s.charAt(i)=='X' && s.charAt(i+1)=='L'){
    			   output = output + 40;
    			   i = i + 2;
    			   continue;
    		   }
    		   else if(s.charAt(i)=='X' && s.charAt(i+1)=='C'){
    			   output = output + 90;
    			   i = i + 2;
    			   continue;
    		   }
    		   else if(s.charAt(i)=='C' && s.charAt(i+1)=='D'){
    			   output = output + 400;
    			   i = i + 2;
    			   continue;
    		   }
    		   else if(s.charAt(i)=='C' && s.charAt(i+1)=='M'){
    			   output = output + 900;
    			   i = i + 2;
    			   continue;
    		   }
    	   }
    	   
    	   if(s.charAt(i)=='I'){
    		   output = output + 1;
    		   i++;
    	   }
    	   else if(s.charAt(i)=='V'){
    		   output = output + 5;
    		   i++;
    	   }
    	   else if(s.charAt(i)=='X'){
    		   output = output + 10;
    		   i++;
    	   }
    	   else if(s.charAt(i)=='L'){
    		   output = output + 50;
    		   i++;
    	   }
    	   else if(s.charAt(i)=='C'){
    		   output = output + 100;
    		   i++;
    	   }
    	   else if(s.charAt(i)=='D'){
    		   output = output + 500;
    		   i++;
    	   }
    	   else if(s.charAt(i)=='M'){
    		   output = output + 1000;
    		   i++;
    	   }
       }
       return output;
    }
    
    public static void main(String[] args){
    	RomanToInteger obj = new RomanToInteger();
    	System.out.println(obj.romanToInt("III"));
    	System.out.println(obj.romanToInt("IV"));
    	System.out.println(obj.romanToInt("IX"));
    	System.out.println(obj.romanToInt("LVIII"));
    	System.out.println(obj.romanToInt("MCMXCIV"));
    }
}
