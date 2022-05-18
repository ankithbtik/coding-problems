package leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * Leetcode problem: https://leetcode.com/problems/two-sum/
 */
public class Solution0013 {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            List<Integer> valList = map.getOrDefault(nums[i], new ArrayList<>());
            valList.add(i);
            map.put(nums[i], valList);
        }

        int[] result = new int[2];

        for(int i=0; i<nums.length; i++){
            result[0]=i;
            List<Integer> indexes = map.getOrDefault(target-nums[i], new ArrayList<>());

            int nextIndex = findNextIndex(indexes, i);
            if(nextIndex != -1){
                result[1]=nextIndex;
                break;
            }
        }

        return result;

    }

    private int findNextIndex(List<Integer> indexes, int curIndex){
        if(indexes.isEmpty()){
            return -1;
        }
        for(int index: indexes){
            if(index != curIndex){
                return index;
            }
            continue;
        }
        return -1;
    }
}
