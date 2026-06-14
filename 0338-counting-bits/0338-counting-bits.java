class Solution {
    public int[] countBits(int n) {

        int[] ans = new int[n+1];

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        for(int i = n; i>=0; i--) {

            ans[i] = countOnes(i, dp);
        }

        return ans;
    }

    public int countOnes(int n, int[] dp) {

        if(n == 0) {
            return 0;
        }

        if(dp[n] != -1) return dp[n];

        return dp[n] = n % 2 + countOnes(n / 2, dp);
    }
}