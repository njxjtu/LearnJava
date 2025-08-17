package LearnJava;

import java.util.Arrays;

public class PlusOne {
    
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Iterate from the last digit
        for (int i = n - 1; i >= 0; i--) {
            // Increment the digit
            digits[i]++;
            // If it's less than 10, no carry, so we can return
            if (digits[i] < 10) {
                return digits;
            }
            // If it's 10, it becomes 0, and we carry over to the next digit
            digits[i] = 0;
        }

        // If we reach here, it means all digits were 9s (e.g., [9, 9, 9])
        // We need to create a new array with an additional digit at the beginning
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }

    public static void main(String args[]){
        int[] digits = {9,8,7,6,5,4,3,2,1,0};
        PlusOne p = new PlusOne();
        int[] digits2 = p.plusOne(digits);
        // Using Arrays.toString for a cleaner output
        System.out.println("Input: " + Arrays.toString(digits));
        System.out.println("Output: " + Arrays.toString(digits2)); // Expected: [9, 8, 7, 6, 5, 4, 3, 2, 1, 1]

        System.out.println("---");

        // Test case for [9, 9, 9]
        int[] digits3 = {9, 9, 9};
        int[] digits4 = p.plusOne(digits3);
        System.out.println("Input: " + Arrays.toString(digits3));
        System.out.println("Output: " + Arrays.toString(digits4)); // Expected: [1, 0, 0, 0]
    }
}
