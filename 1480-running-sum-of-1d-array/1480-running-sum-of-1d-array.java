class Solution {
    public int[] runningSum(int[] nums) {

        int n = nums.length;
        int[] runningSum = new int[n];

        int currSum = 0;
        for(int i = 0; i < n; i++) {

            currSum += nums[i];
            runningSum[i] = currSum;
        } 
        
        return runningSum;
    }
}