class Solution {
    public int minCost(int n, int[] cuts) {
        
        int c = cuts.length;

        int[] newCuts = new int[c + 2];
        newCuts[0] = 0;
        newCuts[c + 1] = n;

        for(int i = 1; i <= c; i++) {
            newCuts[i] = cuts[i - 1];
        }

        Arrays.sort(newCuts);

        int[][] dp = new int[c + 2][c + 2];

        for (int i = c; i >= 1; i--) {
            for (int j = i; j <= c; j++) {

                int mini = Integer.MAX_VALUE;
                for (int ind = i; ind <= j; ind++) {
                    
                    int ans = newCuts[j + 1] - newCuts[i - 1] + dp[i][ind - 1] + dp[ind + 1][j];
                    mini = Math.min(mini, ans);
                }

                dp[i][j] = mini;
            }
        }

        return dp[1][c];
    }

    /*

    public int helpar(int i, int j, int[] arr, int[][] dp) {

        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int min = (int)1e9;

        for(int ind = i; ind <= j; ind++) {

            int ans = arr[j + 1] - arr[i - 1] + helpar(i, ind - 1, arr, dp) + helpar(ind + 1, j, arr, dp);
            min = Math.min(min, ans);
        }

        dp[i][j] = min;
        
        return min;
    }

    */
}