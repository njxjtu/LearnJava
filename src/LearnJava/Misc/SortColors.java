package LearnJava.Misc;

/*
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects 
of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int p0 = 0; // Pointer for 0s (red)
        int p2 = nums.length - 1; // Pointer for 2s (blue)
        int current = 0; // Current element being examined

        // Iterate through the array with the 'current' pointer
        // Stop when current crosses p2, as elements beyond p2 are already sorted (2s)
        while (current <= p2) {
            if (nums[current] == 0) {
                // If the current element is 0, swap it with the element at p0
                // and increment both p0 and current.
                // The element swapped from p0 to current is guaranteed to be 1 or 2.
                // If it was 0, it would have been handled already.
                // If it was 1, it's now at current and will be processed in the next iteration.
                // If it was 2, it's now at current and will be processed in the next iteration.
                int temp = nums[current];
                nums[current] = nums[p0];
                nums[p0] = temp;
                p0++;
                current++;
            } else if (nums[current] == 2) {
                // If the current element is 2, swap it with the element at p2
                // and decrement p2.
                // We do NOT increment current here because the element swapped from p2
                // could be 0, 1, or 2, and needs to be re-evaluated.
                int temp = nums[current];
                nums[current] = nums[p2];
                nums[p2] = temp;
                p2--;
            } else {
                // If the current element is 1, it's already in its correct relative position
                // (between 0s and 2s), so just move to the next element.
                current++;
            }
        }
    }
    

    public static void main(String[] args) {
        SortColors sc = new SortColors();
        int[] colors = {2, 0, 2, 1, 1, 0};
        System.out.println("Before sorting: " + java.util.Arrays.toString(colors));
        sc.sortColors(colors);
        System.out.println("After sorting:  " + java.util.Arrays.toString(colors));
    }
    
}
