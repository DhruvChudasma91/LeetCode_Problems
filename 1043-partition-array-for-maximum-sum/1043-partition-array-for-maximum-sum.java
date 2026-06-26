class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        int n = arr.length;

        int[] dp = new int[n+1];
        
        for(int first = n - 1; first >= 0; first--) {

            int maxSum = Integer.MIN_VALUE;
            int maxNum = Integer.MIN_VALUE;
            int len = 0;

            for(int last = first; last < Math.min(first + k, n); last++) {

                len++;
                maxNum = Math.max(maxNum, arr[last]);

                int sum = (len * maxNum) + dp[last + 1];

                maxSum = Math.max(sum, maxSum);
            }

            dp[first] = maxSum;

        }

        return dp[0];
    }

    /*

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

    */
}