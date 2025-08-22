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

    public static void main(String[] args) {
        SquareRoot sr = new SquareRoot();
        System.out.println(sr.mySqrt(19));
    }
    
}
