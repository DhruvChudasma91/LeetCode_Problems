class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        int ahead1Buy = 0;
        int ahead1Sell = 0;

        int ahead2Buy = 0;  //Not require ahead2Sell because it never use.

        for(int ind = n - 1; ind>= 0; ind--) {

            int currBuy = Math.max(ahead1Buy, -prices[ind] + ahead1Sell);

            int currSell = Math.max(ahead1Sell, prices[ind] + ahead2Buy);

            ahead2Buy = ahead1Buy;
            ahead1Buy = currBuy;
            ahead1Sell = currSell;
        }

        return ahead1Buy;

        /*
        int[] ahead1 = new int[2];  
        int[] ahead2 = new int[2];

        for(int ind = n-1; ind >= 0; ind--) {  

            int[] curr = new int[2];

            for(int buy = 0; buy <= 1; buy++) {

                if(buy == 1) {

                    int skip = ahead1[1];
                    int take = -prices[ind] + ahead1[0];

                    curr[buy] = Math.max(skip, take);

                } else {

                    int skip = ahead1[0];
                    int take = prices[ind] + ahead2[1];

                    curr[buy] = Math.max(skip, take);
                }
            }

            ahead2 = ahead1;
            ahead1 = curr;
        }

        return ahead1[1];

        */
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