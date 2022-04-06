package leetcode.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Leetcode problem : https://leetcode.com/problems/climbing-stairs/
 */
public class Solution0006 {
    Map<Integer, Integer> stepCount = new HashMap<>();

    public int climbStairs(int n) {
        if(n==1 ){
            return 1;
        }
        if(n==2 ){
            return 2;
        }

        if(!stepCount.containsKey(n)){
            stepCount.put(n, (climbStairs(n-1)+climbStairs(n-2)) );
        }

        return stepCount.get(n);
    }
}
