package LearnJava;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 *
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // 1. Sort the intervals based on their start points.
        // This is the crucial first step.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Use a LinkedList to easily access the last element.
        List<int[]> merged = new LinkedList<>();
        
        // 2. Iterate through the sorted intervals.
        for (int[] interval : intervals) {
            // If the merged list is empty or the current interval does not overlap with the previous one,
            // simply add it to the list.
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } 
            // Otherwise, there is an overlap, so we merge the current and previous intervals.
            else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = mi.merge(intervals);

        System.out.println("Merged intervals: " + Arrays.deepToString(result)); // Expected: [[1, 6], [8, 10], [15, 18]]
    }
}
