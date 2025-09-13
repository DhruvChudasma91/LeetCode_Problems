class Solution {

    public static int findMaximum(int ind, int[] dp, int[] nums) {

        if(ind == 0) return nums[ind];

        if(ind < 0) return 0;

        if(dp[ind] != -1) return dp[ind];

        int pick = nums[ind] + findMaximum(ind - 2, dp, nums);
        int notPick = findMaximum(ind - 1, dp, nums);

        return dp[ind] = Math.max(pick, notPick);
    }

    public int rob(int[] nums) {
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return findMaximum(nums.length - 1, dp, nums);
    }
}