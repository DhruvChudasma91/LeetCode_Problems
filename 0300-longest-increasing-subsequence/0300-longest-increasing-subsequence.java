class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;

        Integer[][] dp = new Integer[n][n+1];

        return helpar(0, -1, n, nums, dp);
    }

    public int helpar(int ind, int prevInd, int n, int[] nums, Integer[][] dp) {

        if(ind >= n) {
            return 0;
        }

        if(dp[ind][prevInd + 1] != null) return dp[ind][prevInd + 1];

        int notTake = helpar(ind + 1, prevInd, n, nums, dp);

        int take = -(int)1e9;
        if(prevInd == -1 || nums[ind] > nums[prevInd]) {
            take = 1 + helpar(ind + 1, ind, n, nums, dp);
        }

        return dp[ind][prevInd + 1] = Math.max(notTake, take);
    }
}