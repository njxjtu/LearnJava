package LearnJava;

/*
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
You must not use any built-in exponent function or operator.
For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 */
public class SquareRoot {

    public int mySqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Input must be a non-negative integer.");
        }
        if (x == 0) {
            return 0;
        }

        long left = 1;
        long right = x;
        long ans = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) ans;
    }

    public int mySqrt2(int x) {

        if (x < 0 ) throw new IllegalArgumentException("Input must be a non-negative integer.");

        else if (x == 0) return 0;
        
        else {
            for (int i = 1; i<= x; i++) {
                if ( i*i == x) return i;
                else if ((i+1)*(i+1) == x) return i+1;
                else if (i*i <= x && (i+1)*(i+1) >=x) {
                    return i;
                }
            }
        }
        return x;
    }
    public static void main(String[] args) {
        SquareRoot sr = new SquareRoot();
        int input = 4;
        System.out.println(sr.mySqrt(input));
        System.out.println(sr.mySqrt2(input));
        input = 19;
        System.out.println(sr.mySqrt(input));
        System.out.println(sr.mySqrt2(input));
        input = 8;
        System.out.println(sr.mySqrt(input));
        System.out.println(sr.mySqrt2(input));
        input = 2147483647;
        System.out.println(sr.mySqrt(input));
        System.out.println(sr.mySqrt2(input));
    }
    
}
