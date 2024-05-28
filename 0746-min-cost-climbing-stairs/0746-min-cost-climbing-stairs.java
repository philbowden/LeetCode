class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        for(int i = 2; i < cost.length; i++) {
            cost[i] = Math.min(cost[i-2], cost[i-1]) + cost[i];
        }
        int res = Math.min(cost[n-1], cost[n-2]);
        return res;
    }
}
/* 
                                i
cost = [1,100,1,1,1,100,1,1,100,1]
                 
dp = [1,100,2, 3, 3, 103,4, 5, 104,6, 6]
*/