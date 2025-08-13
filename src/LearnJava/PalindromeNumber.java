package LearnJava;
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
    	
        if(x<0){
        	return false;
        }
        else if(x==0){
        	return true;
        }
        else{
        	int len = (int)(Math.log10(x)+1);
        	for(int i=0; i<len; i++){
        		//System.out.println("i: "+i+" j: "+(len-i-1));
        		if(len-i-1==i || len-i-1 < i){
        			break;
        		}
        		else {
        			//System.out.println("left: "+x/(int)Math.pow(10, (len-i-1))%10);
        			//System.out.println("right: "+x/(int)Math.pow(10, i)%10);
        			if(x/(int)Math.pow(10, (len-i-1))%10 != x/(int)Math.pow(10, i)%10){return false;}
        		}
        		// (int)Math.pow(10, i)
        	}
        }
    	return true;
    }
    
    public static void main(String[] args){
    	PalindromeNumber obj = new PalindromeNumber();
    	int x = -10;
    	System.out.println(x);
    	System.out.println(obj.isPalindrome(x));
    }
}
