package leetcode.practice;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Leetcode problem: https://leetcode.com/problems/product-of-array-except-self/
 */
public class Solution0010 {

    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] sol = new int[size];

        if (size == 0){
            return sol;
        }

        sol[0] = 1;
        for(int i=1; i<size; i++) {
            sol[i] = nums[i-1]*sol[i-1];
        }

        int prev = 1;
        for(int j=size-1; j>=0; j--) {

            sol[j] = sol[j] * prev;
            prev = prev*nums[j];
        }

        return sol;
    }

}
