package LearnJava;
/*
Pow(x, n)
Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25


Example:
0.00001
2147483647

Example:
1.00000
-2147483648

Example:
2.00000
-2147483648
Expected output: 0.0
Note:

-100.0 < x < 100.0
n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */
public class Pow {
    public double myPow(double x, int n) {
    	double rslt;
        if(n==0){
        	rslt = 1; 
        }
        else if(n==1){
        	rslt = x;
        }
        else if(n<0){
        	if(n%2==0){
        		rslt = 1/(myPow(x, -(n/2))*myPow(x, -(n/2)));
        	}
        	else{
        		rslt = 1/(myPow(x, -(n/2))*myPow(x, -(n/2))*myPow(x, -(n%2)));
        	}
        }
        else {
        	double tempd = myPow(x, n/2);
        	if(n%2==0){
        		rslt = tempd*tempd;
        	}
        	else{
        		rslt = tempd*tempd*myPow(x, n%2);
        	}
        }
        return rslt;
    }
    
    public static void main(String[] args){
    	Pow obj = new Pow();
    	System.out.print(obj.myPow(2.00000, -2147483648));
    	//System.out.print(obj.myPow(2, -3));
    }
}
