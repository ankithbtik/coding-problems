package leetcode.practice;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * A subarray is a contiguous part of an array.
 *
 * Leetcode problem: https://leetcode.com/problems/maximum-subarray/
 */
public class Solution0012 {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int maxSum = nums[0];
        int curMaxSum = nums[0];

        for(int i=1; i<nums.length; i++){
            int num = nums[i];

            curMaxSum = Math.max(num, curMaxSum+num);
            maxSum = Math.max(maxSum, curMaxSum);
        }

        return maxSum;
    }
}
