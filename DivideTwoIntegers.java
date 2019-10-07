/*
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2

Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: 
[−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 2^31 − 1 when the division 
result overflows.
*/
class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
    	int count = 0;
    	int a = dividend>0 ? dividend : -dividend, b = divisor>0 ? divisor : -divisor;

    	if(divisor == -1 && dividend==Integer.MIN_VALUE){
    		return Integer.MAX_VALUE;
    	}
    	else if(divisor == 1 && dividend==Integer.MIN_VALUE){
    		return Integer.MIN_VALUE;
    	}
        else{
    		if(a>b){ 
    			count = divide(a-b, b)+1; 
    			}
    		else if(a==b){
    			count = 1 ;
    		}
    	}
        if(dividend>0 && divisor>0 || dividend<0&&divisor<0){
        	return count;
        }
        else{
        	return -count;
        }
    }
    
    public static void main(String[] args){
    	DivideTwoIntegers obj = new DivideTwoIntegers();
    	System.out.println(2147483647/2);
    	System.out.println(obj.divide(2147483647,2));
    }
}
