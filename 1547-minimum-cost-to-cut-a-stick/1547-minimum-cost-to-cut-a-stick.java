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
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return helpar(1, newCuts.length - 2, newCuts, dp);
    }

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
}