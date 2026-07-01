// Space Optimised
public class Solution {
    public int deleteAndEarn(int[] nums) {
        final int MAX = 10005;
        int[] sums = new int[MAX];
        
        // Calculate the total points for each value
        for (int num : nums) {
            sums[num] += num;
        }
        
        // Initialize variables for space optimization
        int prev1 = sums[1]; // dp[i - 2]
        int prev2 = Math.max(sums[1], sums[2]); // dp[i - 1]
        
        // Fill the DP values
        for (int i = 3; i < MAX; i++) {
            int current = Math.max(sums[i] + prev1, prev2);
            prev1 = prev2; // Update prev1 to dp[i - 2]
            prev2 = current; // Update prev2 to dp[i - 1]
        }
        
        // Return the maximum value between the last two DP values
        return prev2;
    }
}