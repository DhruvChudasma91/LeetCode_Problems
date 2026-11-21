class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        int buy = prices[0];
        int maxProfit = 0;

        for(int price : prices) {

            if(price < buy) {
                buy = price;
            }

            int currProfit = price - buy;

            maxProfit = Math.max(currProfit, maxProfit);
        }

        return maxProfit;
    }
}