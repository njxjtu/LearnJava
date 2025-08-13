package LearnJava;
public class StringToInteger {
    public int myAtoi(String str) {
        StringBuilder strb = new StringBuilder();
        boolean minusSign = false, digitStart = false, otherStart = false, plusSign = false;
        
        
        for(int i=0; i<str.length(); i++){
        	if(!minusSign && !plusSign && !digitStart && str.charAt(i)==' ') {System.out.println(" whitespace ");}
        	else if(!minusSign && !plusSign && !digitStart && str.charAt(i)=='+'){
        		plusSign = true;
        		strb.append(str.charAt(i));
        		System.out.println(" plus ");
        	}
        	else if(!minusSign &&  !plusSign && !digitStart && str.charAt(i)=='-'){
        		minusSign = true;
        		strb.append(str.charAt(i));
        		System.out.println(" minus ");
        	}
        	else if(digitStart && !Character.isDigit(str.charAt(i))){
        		System.out.println(" break - started ");
        		break;
        	}
        	else if(!digitStart && !Character.isDigit(str.charAt(i))){
        		otherStart = true;
        		System.out.println(" break - other started : "+str.charAt(i));
        		break;
        	}
        	else if(Character.isDigit(str.charAt(i))){
        		digitStart = true;
        		strb.append(str.charAt(i));
        		System.out.println(" regular ");
        	}
        }
        
        try{
        	if(digitStart && !otherStart){
        		return Integer.parseInt(strb.toString());
        	}
        	else return 0;
        }
        catch(Exception e){
        	System.out.println("In catch - max: "+Integer.MAX_VALUE+" min: "+Integer.MIN_VALUE);
        	return (minusSign)? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }
    
    public static void main(String[] args){
    	StringToInteger obj = new StringToInteger();
    	System.out.println(obj.myAtoi("   +0 123"));
    }
}
