class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        if(n == 0) return 0;

        int[][] dp = new int[n][2];
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return helper(0, 0, n, prices, dp);
    }

    public int helper(int ind, int buy, int n, int[] prices, int[][] dp){

        if(ind == n) return 0;

        if(dp[ind][buy] != -1) return dp[ind][buy];

        int profit = 0;

        if(buy == 0) {

            int skip = helper(ind + 1, buy, n, prices, dp);
            int take = (-1 * prices[ind]) + helper(ind + 1, 1, n, prices, dp);

            profit = Math.max(skip, take);
        }

        if(buy == 1){

           int skip = helper(ind + 1, buy, n, prices, dp); 
           int use = prices[ind] + helper(ind + 1, 0, n, prices, dp);

           profit = Math.max(skip, use);
        }

        return dp[ind][buy] = profit;
    }
}