package leetcode.practice;

/**
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 * A subarray is a contiguous subsequence of the array.
 *
 * Leetcode problem: https://leetcode.com/problems/maximum-product-subarray/
 */
public class Solution0011 {
    public int maxProduct(int[] nums) {

        if(nums.length == 0){
            return 0;
        }

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for(int i=1; i<nums.length; i++){
            int cur = nums[i];
            int cur_max = Math.max(cur, Math.max(max_so_far*cur, min_so_far*cur));
            int cur_min = Math.min(cur, Math.min(max_so_far*cur, min_so_far*cur));

            max_so_far = cur_max;
            min_so_far = cur_min;

            result = Math.max(max_so_far, result);
        }

        return result;

    }
}
