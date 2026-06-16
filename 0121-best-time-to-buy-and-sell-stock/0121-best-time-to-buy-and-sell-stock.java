class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int minCost = prices[0];
        int profite = 0;

        for(int i = 1; i < n; i++) {

            int cost = prices[i] - minCost;

            profite = Math.max(cost, profite);

            minCost = Math.min(minCost, prices[i]);
        }

        return profite;
        
    }
}