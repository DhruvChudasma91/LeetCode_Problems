class Solution {
    public long maximumProfit(int[] prices, int k) {
        
        int n = prices.length;

        long[][] ahead = new long[3][k + 1];

        for(int i = 0; i<=k; i++) {
            ahead[0][i] = 0;
            ahead[1][i] = -(long)1e15;
            ahead[2][i] = -(long)1e15;
        }

        for(int ind = n - 1; ind >= 0; ind--) {

            long[][] curr = new long[3][k + 1];
            curr[0][0] = 0;
            curr[1][0] = -(long)1e15;
            curr[2][0] = -(long)1e15;

            for(int state = 0; state <= 2; state++) {

                for(int cap = 1; cap <= k; cap++) {

                    if(state == 0) {

                        long skip = ahead[0][cap];
                        long normalBuy = -prices[ind] + ahead[1][cap];
                        long shortSell = prices[ind] + ahead[2][cap];

                        curr[state][cap] = Math.max(skip, Math.max(normalBuy, shortSell));

                    } else if(state == 1) {

                        long skip = ahead[1][cap];
                        long normalSell = prices[ind] + ahead[0][cap - 1];

                        curr[state][cap] = Math.max(skip, normalSell);

                    } else {

                        long skip = ahead[2][cap];
                        long shortBuy = -prices[ind] + ahead[0][cap - 1];

                        curr[state][cap] = Math.max(skip, shortBuy);
                    }
                }
            }

            ahead = curr;
        }

        return ahead[0][k];  
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