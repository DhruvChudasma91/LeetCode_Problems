class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int n = coins.length;

        int[][] dp = new int[n][amount+1];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }

        int ans = helper(n-1, amount, coins, dp);

        return ans >= 1e9 ? -1 : ans;
    }

    public static int helper(int ind, int x, int[] arr, int[][] dp) {

        if(x == 0) return 0;

        if(ind == 0) {

            if(x % arr[0] == 0) {
                return x/arr[0];
            } else {
                return (int)1e9;
            }
        }

        if(dp[ind][x] != -1) return dp[ind][x];

        int notPick = helper(ind-1, x, arr, dp);
        int pick = (int)1e9;

        if(x >= arr[ind]){
            pick = 1 + helper(ind, x - arr[ind], arr, dp);
        }

        return dp[ind][x] = Math.min(notPick, pick);
    }
}