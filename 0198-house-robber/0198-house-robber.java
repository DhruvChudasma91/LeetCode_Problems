class Solution {

    public static int findMaximum(int n, int[] dp, int[] nums) {

        dp[0] = nums[0];

        for(int i = 1; i < n; i++) {

            int pick = nums[i];

            if(i > 1) {
                pick += dp[i-2];
            }

            int notPick = dp[i - 1];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[n-1];
    }

    public int rob(int[] nums) {
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return findMaximum(nums.length, dp, nums);
    }
}