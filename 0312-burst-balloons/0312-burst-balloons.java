class Solution {
    public int maxCoins(int[] nums) {
        
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        for(int i = 1; i <= n; i++) {
            arr[i] = nums[i - 1];
        }

        int[][] dp = new int[n + 2][n + 2];

        for(int i = n; i >= 1; i--) {
            for(int j = 1; j <= n; j++) {

                if(i > j) continue;
                int max = -(int)1e9;

                for(int ind = i; ind <= j; ind++) {

                    int coins = arr[i - 1] * arr[ind] * arr[j + 1] + dp[i][ind - 1] + dp[ind + 1][j];
                    max = Math.max(max, coins);
                }

                dp[i][j] = max;
            }
        }

        return dp[1][n];
    }

    /*

    public int helpar(int i, int j, int[] arr, int[][] dp) {

        if(i > j) {
            return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];

        int max = -(int)1e9;

        for(int ind = i; ind <= j; ind++) {

            int coins = arr[i - 1] * arr[ind] * arr[j + 1] + helpar(i, ind - 1, arr, dp) + helpar(ind + 1, j, arr, dp);
            max = Math.max(max, coins);
        }

        dp[i][j] = max;

        return max;
    }

    */
}