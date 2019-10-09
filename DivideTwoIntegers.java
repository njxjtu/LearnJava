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

Example 3:
input: 
-2147483648
-1
Expected output: 2147483647

Example 4:
input: 
-2147483648
1
Expected output: -2147483648

Example 5:
input: 
2147483647
2
Expected output: 
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: 
[−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 2^31 − 1 when the division 
result overflows.
*/
/*
 * Solution 1: Brute force approach
 * Subtraction
 * 
 * Solution 2: Bitwise operator
 * dividend = quotient * divisor + remainder
 * every number can be represented by binary base(0/1)
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
    
    public int divide2(int dividend, int divisor) {
    	
    	long a = dividend>0 ? (long)dividend : -(long)dividend, b = divisor>0 ? (long)divisor : -(long)divisor;
        
    	if(divisor == -1 && dividend==Integer.MIN_VALUE){
    		return Integer.MAX_VALUE;
    	}
    	else if(divisor == 1 && dividend==Integer.MIN_VALUE){
    		return Integer.MIN_VALUE;
    	}
        else{
        	int shift = 31; long tempc=0, tempb=0;
    		while(shift>=0){ 
    			if(b<<shift <= a-tempb){
    				tempb = (b<<shift) + tempb;
    				tempc = (1<<shift) + tempc;
    			};
    			shift--;
    			}
    		if(dividend>0 && divisor>0 || dividend<0&&divisor<0){
            	return (int)tempc;
            }
            else{
            	return (int)-tempc;
            }
    	}
        
    }
    
    public static void main(String[] args){
    	DivideTwoIntegers obj = new DivideTwoIntegers();
    	//System.out.println(-2147483648/-1);
    	System.out.println(obj.divide2(-10,-3));
    }
}
