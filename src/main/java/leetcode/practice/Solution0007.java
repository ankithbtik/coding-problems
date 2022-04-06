package leetcode.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can
 * rob tonight without alerting the police.
 *
 * Leetcode problem : https://leetcode.com/problems/house-robber/
 */
public class Solution0007 {

    Map<Integer, Integer> robberyMap = new HashMap<>();

    public int rob(int[] nums) {
        return maxRobberyAtHouse(nums.length, nums);
    }

    public int maxRobberyAtHouse(int n, int[] nums){
        // base cases
        if(n == 1){
            return nums[0];
        }
        if (n == 2){
            return Math.max(nums[0], nums[1]);
        }

        if(!robberyMap.containsKey(n)){
            robberyMap.put(n, Math.max(maxRobberyAtHouse(n-1, nums), maxRobberyAtHouse(n-2, nums)+nums[n-1]));
        }

        return robberyMap.get(n);

    }
}
