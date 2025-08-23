package LearnJava;

public class Fibonacci {

    public long fib(int n) {
        // This is a classic recursive implementation.
        // It's very slow for larger n (like 50) due to its exponential
        // time complexity O(2^n), as it recalculates the same values many times.
        if (n <= 1) {
            return n; // Standard base cases: F(0)=0, F(1)=1
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * Calculates the nth Fibonacci number using an iterative approach (Dynamic Programming).
     * This is much more efficient than the recursive `fib` method.
     * It also correctly handles large numbers up to the limit of the `long` data type.
     * The 93rd Fibonacci number is the first one to overflow a `long`.
     * @param n The index in the Fibonacci sequence.
     * @return The nth Fibonacci number.
     */
    public long fib2(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input cannot be negative.");
        }
        if (n <= 1) {
            return n;
        }

        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 50;
        Fibonacci fib= new Fibonacci();

        System.out.println("Calculating F(50)...");

        // The recursive fib(n) is too slow for n=50.
        // Uncommenting the line below will cause a very long wait.
        // System.out.println ("fib(50) result (recursive): " + fib.fib(n));

        System.out.println ("fib2(50) result (iterative): " + fib.fib2(n));

        // The 93rd Fibonacci number is the first to exceed Long.MAX_VALUE
        System.out.println("F(92): " + fib.fib2(92));
        System.out.println("F(93) (overflows long): " + fib.fib2(93));
    }
    
}
