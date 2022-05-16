package leetcode.practice;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 * Leetcode problem: https://leetcode.com/problems/trapping-rain-water/
 */
public class Solution0009 {
    public int trap(int[] height) {
        if(height.length == 0){
            return 0;
        }

        int size = height.length;
        int[] left_max = new int[size];
        int[] right_max = new int[size];

        left_max[0] = height[0];
        for(int i=1; i<size; i++){
            left_max[i] = Math.max(height[i], left_max[i-1]);
        }

        right_max[size-1] = height[size-1];
        for(int i=size-2; i>=0; i--){
            right_max[i] = Math.max(height[i], right_max[i+1]);
        }

        int total = 0;

        for(int i=1; i<size-1; i++){
            total += Math.min(left_max[i], right_max[i]) - height[i];
        }

        return total;
    }
}
