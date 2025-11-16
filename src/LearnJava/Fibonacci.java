package LearnJava;

public class Fibonacci {

    public long fib(int n) {
        if (n <= 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }
        else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public long fib2(int n) {
        long[] fArray = new long[n];
        for (int i = 0; i < n; i++) {
            if (i==0) {
                fArray[i] = 0;
            }
            else if (i==1) {
                fArray[i] = 1;
            }
            else {
                fArray[i] = fArray[i-1] + fArray[i-2];
            }
            }
        return fArray[n-1];
    }

    public static void main(String[] args) {
        int n = 20;
        Fibonacci fib= new Fibonacci();
        System.out.println (fib.fib(n));
        System.out.println (fib.fib2(n));
    }
    
}
