/**
 * You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
 *
 * Return true if the edges of the given graph make up a valid tree, and false otherwise.
 *
 * Leetcode problem : https://leetcode.com/problems/graph-valid-tree/
 */
public class Solution0003 {
    public boolean validTree(int n, int[][] edges) {

        if(edges.length != (n-1)){
            return false;
        }
        int[] parents = new int[n];
        for(int i=0; i<n; i++){
            parents[i] = -1;
        }

        for(int[] edge: edges){

            int sourceParent = findParent(parents, edge[0]);
            int targetParent = findParent(parents, edge[1]);

            if(sourceParent == targetParent) {
                return false;

            } else {
                union(parents, sourceParent, targetParent);
            }

        }
        return true;

    }

    int findParent(int[] parents, int node){
        int i = node;
        while(parents[i] >= 0){
            i = parents[i];
        }
        return i;
    }

    void union(int[] parents, int source, int target){
        parents[target] = source;
    }
}
