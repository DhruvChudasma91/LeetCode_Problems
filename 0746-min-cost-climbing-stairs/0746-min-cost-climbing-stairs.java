class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return helpar(n, cost, dp);
    }

    public int helpar(int ind, int[] cost, int[] dp) {

        if(ind == 0) {
            return 0;
        }

        if(dp[ind] != -1) return dp[ind];

        int jumpOne = cost[ind - 1] + helpar(ind - 1, cost, dp);
        int jumpTwo = 0;

        if(ind > 1) {
            jumpTwo = cost[ind - 2] + helpar(ind - 2, cost, dp);
        }

        return dp[ind] = Math.min(jumpOne, jumpTwo);
    }
}