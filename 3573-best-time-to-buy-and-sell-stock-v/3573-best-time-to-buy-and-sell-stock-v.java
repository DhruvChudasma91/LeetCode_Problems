class Solution {
    public long maximumProfit(int[] prices, int k) {
        
        int n = prices.length;

        long[][][] dp = new long[n + 1][3][k + 1];

        for(int i = 0; i<=k; i++) {
            dp[n][0][i] = 0;
            dp[n][1][i] = -(long)1e15;
            dp[n][2][i] = -(long)1e15;
        }

        for(int i = 0; i <= n; i++) {

            dp[i][0][0] = 0;
            dp[i][1][0] = -(long)1e15;
            dp[i][2][0] = -(long)1e15;
        }

        for(int ind = n - 1; ind >= 0; ind--) {

            for(int state = 0; state <= 2; state++) {

                for(int cap = 1; cap <= k; cap++) {

                    if(state == 0) {

                        long skip = dp[ind + 1][0][cap];
                        long normalBuy = -prices[ind] + dp[ind + 1][1][cap];
                        long shortSell = prices[ind] + dp[ind + 1][2][cap];

                        dp[ind][state][cap] = Math.max(skip, Math.max(normalBuy, shortSell));

                    } else if(state == 1) {

                        long skip = dp[ind + 1][1][cap];
                        long normalSell = prices[ind] + dp[ind + 1][0][cap - 1];

                        dp[ind][state][cap] = Math.max(skip, normalSell);

                    } else {

                        long skip = dp[ind + 1][2][cap];
                        long shortBuy = -prices[ind] + dp[ind + 1][0][cap - 1];

                        dp[ind][state][cap] = Math.max(skip, shortBuy);
                    }
                }
            }
        }


        return dp[0][0][k];
        

    }

    /*
    public long helpar(int ind, int state, int cap, int n, int[] prices, Long[][][] dp) {

        if(ind == n || cap == 0) {

            if(state == 0 ) {
                return 0;
            } else {
                return -(long)1e15;
            }
        }

        if(dp[ind][state][cap] != null) return dp[ind][state][cap];

        long profit = 0;
        if(state == 0) {

            long skip = helpar(ind + 1, 0, cap, n, prices, dp);

            long normalBuy = -prices[ind] + helpar(ind + 1, 1, cap, n, prices, dp);
 
            long shortSell = prices[ind] + helpar(ind + 1, 2, cap, n, prices, dp);
            
            profit = Math.max(skip, Math.max(normalBuy, shortSell));

        } else if(state == 1) {

            long skip = helpar(ind + 1, 1, cap, n, prices, dp);
            long normalSell = prices[ind] + helpar(ind + 1, 0, cap - 1, n, prices, dp);

            profit = Math.max(skip, normalSell);

        } else {

            long skip = helpar(ind + 1, 2, cap, n, prices, dp);
            long shortBuy = -prices[ind] + helpar(ind + 1, 0, cap - 1, n, prices, dp);

            profit = Math.max(skip, shortBuy);
        }

        dp[ind][state][cap] = profit;
        return profit;
    }

    */
}