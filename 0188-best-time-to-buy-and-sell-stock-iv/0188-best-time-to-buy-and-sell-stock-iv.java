class Solution {
    public int maxProfit(int k, int[] prices) {
        
        int n = prices.length;

        if(n == 0 || k == 0) return 0;

        int[] buy = new int[k+1];
        int[] sell = new int[k+1];

        for(int i = 0; i <= k; i++) {
            buy[i] = Integer.MIN_VALUE;
        }

        for(int price : prices) {

            for(int t = 1; t <= k; t++) {

                buy[t] = Math.max(buy[t], sell[t-1] - price);
                sell[t] = Math.max(sell[t], buy[t] + price);
            }
        }

        return sell[k];
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