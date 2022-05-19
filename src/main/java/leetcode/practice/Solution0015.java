package leetcode.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
 * Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
 * Return the maximum number of points you can earn by applying the above operation some number of times.
 *
 * Leetcode problem: https://leetcode.com/problems/delete-and-earn/
 */
public class Solution0015 {
    int max = Integer.MIN_VALUE;
    Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
    Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();

    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        for(int num : nums){
            int val = countMap.getOrDefault(num, 0);
            countMap.put(num, val+num);
            max = Math.max(max, num);
        }

        return maxEarned(max);
    }

    // 'maxEarned' is the function that returns the maximum points that can
    // be earned when values in 'nums' array is between 0 and 'val'.
    private int maxEarned(int val){
        if(val == 0){
            return 0;
        }
        if (val == 1){
            return countMap.getOrDefault(1, 0);
        }

        if(resultMap.containsKey(val)){
            return resultMap.get(val);
        }

        int res = Math.max((countMap.getOrDefault(val, 0)+maxEarned(val-2)), maxEarned(val-1));
        resultMap.put(val, res);
        return res;

    }
}
