package LearnJava;
/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
    	if(num1.equals("0") || num2.equals("0")){
    		return "0";
    	}
        int[] multiRes = new int[num1.length()+num2.length()-1];
        for(int i=0; i<num1.length(); i++){
        	for(int j=0; j<num2.length(); j++){
        		multiRes[i+j]=multiRes[i+j]+(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
        	}
        }
        
        for(int i=multiRes.length-1; i>0; i--){
        	multiRes[i-1] = multiRes[i-1]+ multiRes[i]/10;
        	multiRes[i]=multiRes[i]%10;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i : multiRes){
        	sb.append(i);
        }
        return sb.toString();
    }
    
    public static void main(String[] args){
    	MultiplyStrings obj = new MultiplyStrings();
    	System.out.println(obj.multiply("160", "0"));
    }
}
