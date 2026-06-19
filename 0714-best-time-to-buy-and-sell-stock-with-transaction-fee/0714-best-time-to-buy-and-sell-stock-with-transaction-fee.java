class Solution {
    public int maxProfit(int[] prices, int fee) {

        int n = prices.length;

        int aheadBuy = 0;
        int aheadSell = 0;

        for(int ind = n-1; ind >= 0; ind--) {

            int currBuy = Math.max(aheadBuy, -prices[ind] + aheadSell);
            int currSell = Math.max(aheadSell, prices[ind] - fee + aheadBuy);

            aheadBuy = currBuy;
            aheadSell = currSell;
        }

        return aheadBuy;
        
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