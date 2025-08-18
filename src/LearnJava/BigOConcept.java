package LearnJava;

/* Big O notation is a fundamental concept in computer science used to 
describe the efficiency or complexity of an algorithm. It's a way of 
classifying algorithms by how their performance or resource usage 
(like time or space) scales with the size of the input data. Instead of 
measuring the exact time an algorithm takes, which can vary based on 
hardware, Big O focuses on the rate of growth of the number of operations.
 */
public class BigOConcept {

    /**
     * Performs a binary search on a sorted array to find the index of a target element.
     * This method has a time complexity of O(log n).
     *
     * @param arr The sorted array to search within.
     * @param target The element to search for.
     * @return The index of the target element if found, otherwise -1.
     */
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate mid to prevent potential overflow

            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                low = mid + 1; // Discard left half, search in the right half
            } else {
                high = mid - 1; // Discard right half, search in the left half
            }
        }
        return -1; // Target not found
    }

        // Main sort method
    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Already sorted or empty
        }
        int[] temp = new int[arr.length]; // Temporary array for merging
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    // Recursive merge sort method
    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Calculate middle point
            mergeSort(arr, temp, left, mid); // Sort first half
            mergeSort(arr, temp, mid + 1, right); // Sort second half
            merge(arr, temp, left, mid, right); // Merge the two halves
        }
    }

        // Merge two sorted sub-arrays
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // Copy elements to temporary array
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left; // Pointer for the left sub-array
        int j = mid + 1; // Pointer for the right sub-array
        int k = left; // Pointer for the original array

        // Merge back into the original array
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        // Copy remaining elements of left sub-array, if any
        while (i <= mid) {
            arr[k++] = temp[i++];
        }

        // Remaining elements of right sub-array are already in place (or handled by the above loop)
    }


    public static void main(String args[]){

        int n = 10;

        // O(1) - Constant Time
        int[] numbers = {1, 2, 3, 4, 5};
        int thirdElement = numbers[2]; // This operation is always one step.
        System.out.println(thirdElement);

        // O(n) - Linear Time
        for (int i = 0; i < n; i++) {
           System.out.println(i); // This loop runs 'n' times.
        }

        // O(logn) - Logarithmic Time
        int[] sortedArray = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target1 = 23;
        int target2 = 10;

        System.out.println("Index of " + target1 + ": " + binarySearch(sortedArray, target1)); // Expected: 5
        System.out.println("Index of " + target2 + ": " + binarySearch(sortedArray, target2)); // Expected: -1

        // O(nlogn) - Linearithmic Time - The running time is a combination of linear and logarithmic growth. 
        //                                This is a very common and efficient complexity for sorting algorithms.
        // Example: Merge Sort
        int[] data = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array:");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println();

        sort(data);

        System.out.println("Sorted array:");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println();

    }

    
}
