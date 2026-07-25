class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        int n = arr.length;

        int[] dp = new int[n+1];
       
        for(int first = n - 1; first >= 0; first--) {

            int maxNum = Integer.MIN_VALUE;
            int maxSum = Integer.MIN_VALUE;

            for(int last = first; last < Math.min(n, first + k); last++) {

                int len = (last - first) + 1;

                maxNum = Math.max(maxNum, arr[last]);

                int sum = (maxNum * len) + dp[last + 1];

                maxSum = Math.max(sum, maxSum);
            }

            dp[first] = maxSum;

        }

        return dp[0];
        
    }

    /*
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
    */
}