class Solution {
    public long maximumProfit(int[] prices, int k) {
        
        int n = prices.length;

        Long[][][] dp = new Long[n][3][k + 1];

        return helpar(0, 0, k, n, prices, dp);
    }

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
}