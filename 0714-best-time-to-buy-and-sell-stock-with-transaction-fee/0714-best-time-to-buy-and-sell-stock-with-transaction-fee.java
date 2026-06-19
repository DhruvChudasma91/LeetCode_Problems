class Solution {
    public int maxProfit(int[] prices, int fee) {

        int n = prices.length;

        int[][] dp = new int[n+1][2];

        for(int ind = n-1; ind >= 0; ind--) {

            for(int buy = 0; buy <= 1; buy++) {

                if(buy == 1) {

                    int skip = dp[ind+1][1];
                    int take = -prices[ind] + dp[ind+1][0];

                    dp[ind][buy] = Math.max(skip, take);
                } else {
                    
                    int skip = dp[ind+1][0];
                    int take = prices[ind] - fee + dp[ind+1][1];

                    dp[ind][buy] = Math.max(skip, take);

                }
            }
        }

        return dp[0][1];
        
    }

    /*

    public static int helpar(int ind, int buy, int fee, int n, int[] prices, int[][] dp) {

        if(ind == n) {
            return 0;
        }

        if(dp[ind][buy] != -1) return dp[ind][buy];

        int profit = 0;
        if(buy == 1) {

            int skip = helpar(ind + 1, 1, fee, n, prices, dp);
            int take = -prices[ind] + helpar(ind + 1, 0, fee, n, prices, dp);

            profit = Math.max(skip, take);

        } else {

            int skip = helpar(ind + 1, 0, fee, n, prices, dp);
            int take = prices[ind] - fee + helpar(ind + 1, 1, fee, n, prices, dp);

            profit = Math.max(skip, take);
        }

        dp[ind][buy] = profit;
        
        return profit;
    }

    */
}