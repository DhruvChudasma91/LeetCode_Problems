class Solution {
    public boolean validPartition(int[] nums) {
        
        int n = nums.length;

        if(n == 1) {return false;}

        Boolean[] dp = new Boolean[n];

        return helper(0, n, nums, dp);
    }

    public boolean helper(int index, int n, int[] nums, Boolean[] dp) {

        if (index == n)
            return true;

        if(dp[index] != null) return dp[index];

        // Case 1 : Two equal elements
        if (index + 1 < n &&
            nums[index] == nums[index + 1]) {

            if (helper(index + 2, n, nums, dp))
                return dp[index] = true;
        }

        // Case 2 : Three equal elements
        if (index + 2 < n &&
            nums[index] == nums[index + 1] &&
            nums[index + 1] == nums[index + 2]) {

            if (helper(index + 3, n, nums, dp))
                return dp[index] = true;
        }

        // Case 3 : Three consecutive increasing
        if (index + 2 < n &&
            nums[index] + 1 == nums[index + 1] &&
            nums[index + 1] + 1 == nums[index + 2]) {

            if (helper(index + 3, n, nums, dp))
                return dp[index] = true;
        }

        return dp[index] = false;
    }
}