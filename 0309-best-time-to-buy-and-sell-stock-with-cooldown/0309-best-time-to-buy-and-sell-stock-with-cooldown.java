class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        int[][] dp = new int[n+2][2];

        for(int ind = n-1; ind >= 0; ind--) {  //n = 5, n + 1 = 6 // n - 2 + 2 => 5 - 1 + 2 => 6

            for(int buy = 0; buy <= 1; buy++) {

                if(buy == 1) {

                    int skip = dp[ind + 1][1];
                    int take = -prices[ind] + dp[ind + 1][0];

                    dp[ind][buy] = Math.max(skip, take);

                } else {

                    int skip = dp[ind + 1][0];
                    int take = prices[ind] + dp[ind + 2][1];

                    dp[ind][buy] = Math.max(skip, take);
                }
            }
        }

        return dp[0][1];
    }

    /*

    public int helpar(int ind, int buy, int n, int[] prices, int[][] dp) {

        if(ind >= n) {
            return 0;
        }

        if(dp[ind][buy] != -1) {
            return dp[ind][buy];
        }

        int profit = 0;
        if(buy == 1) {

            int skip = helpar(ind + 1, 1, n, prices, dp);
            int take = -prices[ind] + helpar(ind + 1, 0, n, prices, dp);

            profit = Math.max(skip, take);

        } else {

            int skip = helpar(ind + 1, 0, n, prices, dp);
            int take = prices[ind] + helpar(ind + 2, 1, n, prices, dp);

            profit = Math.max(skip, take);

        }

        dp[ind][buy] = profit;

        return profit;
    }

    */ 
}