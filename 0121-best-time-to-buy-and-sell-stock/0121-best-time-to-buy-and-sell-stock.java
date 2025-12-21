class Solution {
    public int maxProfit(int[] prices) {
        
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int currProfit;

        for(int i = 0; i < prices.length; i++) {

            if(minPrice >= prices[i]) {
                minPrice = prices[i];
            }

            currProfit = prices[i] - minPrice;
            maxProfit = Math.max(currProfit, maxProfit);
        }

        return maxProfit;
    }
}
