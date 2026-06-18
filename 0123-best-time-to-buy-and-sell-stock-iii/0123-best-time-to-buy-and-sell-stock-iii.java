class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        int[][][] dp = new int[n+1][2][3];


        for(int ind = n - 1; ind>= 0; ind--) {

            for(int buy = 0; buy <= 1; buy++) {

                for(int cap = 1; cap <= 2; cap++) {

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

        return dp[0][1][2];
        
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