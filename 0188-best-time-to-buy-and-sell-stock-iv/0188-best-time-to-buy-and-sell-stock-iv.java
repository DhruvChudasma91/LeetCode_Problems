class Solution {
    public int maxProfit(int k, int[] prices) {
        
        int n = prices.length;

        int[][][] dp = new int[n+1][2][k+1];

        for(int ind = n-1; ind>=0; ind--) {
            for(int buy = 0; buy <= 1; buy++) {
                for(int cap = 1; cap <= k; cap++) {

                    if(buy == 1) {

                        int skip = dp[ind + 1][1][cap];
                        int take = -prices[ind] + dp[ind + 1][0][cap];

                        dp[ind][buy][cap] = Math.max(skip, take);

                    } else {

                        int skip = dp[ind + 1][0][cap];
                        int take = prices[ind] + dp[ind + 1][1][cap - 1];

                        dp[ind][buy][cap] = Math.max(skip, take);
                    }

                }
            }
        }

        return dp[0][1][k];
    }

    /*

    public int helpar(int ind, int buy, int cap, int n, int[] prices, int[][][] dp) {

        if(ind  == n || cap == 0){
            return 0;
        }

        if(dp[ind][buy][cap] != -1) return dp[ind][buy][cap];

        int profit = 0;
        if(buy == 1) {

            int skip = helpar(ind + 1, 1, cap, n, prices, dp);
            int take = -prices[ind] + helpar(ind + 1, 0, cap, n, prices, dp);

            profit = Math.max(skip, take);

        } else {

            int skip = helpar(ind + 1, 0, cap, n, prices, dp);
            int take = prices[ind] + helpar(ind + 1, 1, cap - 1, n, prices, dp);

            profit = Math.max(skip, take);
        }

        dp[ind][buy][cap] = profit;

        return profit;
    }

    */
}