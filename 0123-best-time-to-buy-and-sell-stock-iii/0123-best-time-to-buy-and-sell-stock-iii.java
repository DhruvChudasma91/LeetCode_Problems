class Solution {

    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        
        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;

        for(int price : prices) {
           
           firstBuy = Math.max(firstBuy, -price);
           
           firstSell = Math.max(firstSell, firstBuy + price);

           secondBuy = Math.max(secondBuy, firstSell - price);

           secondSell = Math.max(secondSell, secondBuy + price);
            
        }

        return secondSell;  
    }

    /*
    public int helpar(int ind, int buy, int total, int n, int[] prices, int[][][] dp){

        if(ind == n || total == 0){
            return 0;
        }

        if(dp[ind][buy][total] != -1) {
            return dp[ind][buy][total];
        }

        int profit = 0;
        if(buy == 1) {

            int skip = helpar(ind + 1, 1, total, n, prices, dp);
            int take = -prices[ind] + helpar(ind + 1, 0, total, n, prices, dp);

            profit = Math.max(skip, take);
        }

        if(buy == 0) {

            int skip = helpar(ind + 1, 0, total, n, prices, dp);
            int take = prices[ind] + helpar(ind + 1, 1, total - 1, n, prices, dp);

            profit = Math.max(skip, take);
        }

        dp[ind][buy][total] = profit;

        return profit;
    }
    */
}