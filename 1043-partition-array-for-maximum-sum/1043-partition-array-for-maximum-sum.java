class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        int n = arr.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return helpar(0, n, k, arr, dp);
    }

    public int helpar(int first, int n, int k, int[] arr, int[] dp) {

        if(first == n) return 0;

        if(dp[first] != -1) return dp[first];

        int maxSum = Integer.MIN_VALUE;
        int maxNum = Integer.MIN_VALUE;
        int len = 0;

        for(int last = first; last < Math.min(first + k, n); last++) {

            len++;
            maxNum = Math.max(maxNum, arr[last]);

            int sum = (len * maxNum) + helpar(last + 1, n, k, arr, dp);

            maxSum = Math.max(sum, maxSum);
        }

        return dp[first] = maxSum;
    }
}