class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int n = coins.length;

        int[] prev = new int[amount+1];
        
        for(int i = 0; i <= amount; i++) {
            if(i % coins[0] == 0) {
                prev[i] = i / coins[0];
            } else {
                prev[i] = (int)1e9;
            }
        }

        for(int ind = 1; ind < n; ind++) {

            int[] curr = new int[amount+1];
            for(int target = 1; target <= amount; target++) {

                int notPick = prev[target];
                int pick = (int)1e9;

                if(target >= coins[ind]) {
                    pick = 1 + curr[target - coins[ind]];
                }

                curr[target] = Math.min(notPick, pick);
            }

            prev = curr.clone();
        }

        int ans = (prev[amount] == (int)1e9)? -1 : prev[amount];
        return ans;
    }

    // public static int helper(int ind, int x, int[] arr, int[][] dp) {

    //     if(x == 0) return 0;

    //     if(ind == 0) {

    //         if(x % arr[0] == 0) {
    //             return x/arr[0];
    //         } else {
    //             return (int)1e9;
    //         }
    //     }

    //     if(dp[ind][x] != -1) return dp[ind][x];

    //     int notPick = helper(ind-1, x, arr, dp);
    //     int pick = (int)1e9;

    //     if(x >= arr[ind]){
    //         pick = 1 + helper(ind, x - arr[ind], arr, dp);
    //     }

    //     return dp[ind][x] = Math.min(notPick, pick);
    // }
}