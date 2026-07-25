class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        int n = arr.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return helpar(0, n, arr, k, dp);
    }

    public int helpar(int first, int n, int[] arr, int k, int[] dp) {

        if(first == n) {
            return 0;
        }

        if(dp[first] != -1) return dp[first];

        int maxNum = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;

        for(int last = first; last < Math.min(n, first + k); last++) {

            int len = (last - first) + 1;

            maxNum = Math.max(maxNum, arr[last]);

            int sum = (maxNum * len) + helpar(last + 1, n, arr, k, dp);

            maxSum = Math.max(sum, maxSum);
        }

        return dp[first] = maxSum;
    }
}