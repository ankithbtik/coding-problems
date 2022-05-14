package leetcode.practice;

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 *
 * Return the minimum cost to reach the top of the floor.
 *
 * Leetcode problem : https://leetcode.com/problems/min-cost-climbing-stairs/
 */

public class Solution0008 {
    private int[] mem;

    public int minCostClimbingStairs(int[] cost) {

        int numOfStairs = cost.length;
        if(numOfStairs == 0 || numOfStairs == 1){
            return 0;
        }
        if(numOfStairs == 2){
            return Math.min(cost[0], cost[1]);
        }

        this.mem = new int[numOfStairs+1];
        mem[0]=0;
        mem[1]=0;

        for(int i=2; i<=numOfStairs; i++){
            int minCost = Math.min(mem[i-1]+cost[i-1], mem[i-2]+cost[i-2]);
            mem[i]=minCost;
        }

        return mem[numOfStairs];
    }
}
