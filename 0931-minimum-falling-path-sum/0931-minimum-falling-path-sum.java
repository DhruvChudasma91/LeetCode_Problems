class Solution {
    public int minFallingPathSum(int[][] matrix) {

        return tebulation(matrix);
    }

    public int tebulation(int[][] matrix) {

        int n = matrix.length;

        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            dp[n-1][i] = matrix[n-1][i];
        }

        for(int row = n-2; row >= 0; row--) {
            for(int col = 0; col < n; col++) {

                    int below = dp[row+1][col];
                    int lDiago = (int)1e9;
                    int rDiago = (int)1e9;

                    if(col > 0) {
                        lDiago = dp[row+1][col-1];
                    }

                    if(col < n -1) {
                        rDiago = dp[row+1][col+1];
                    }

                    dp[row][col] = matrix[row][col] + Math.min(below, Math.min(lDiago, rDiago));

            }
        }

        int ans = (int)1e9;
        for(int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[0][i]);
        }

        return ans;
    }

    /*

    public int memoization(int row, int col, int n, int m, int[][] matrix, Integer[][] dp) {

        if(row >= n || col >= m || col < 0) {
            return (int)1e9;
        }

        if(row == n-1) {
            return matrix[row][col];
        }

        if(dp[row][col] != null) return dp[row][col];

        int below = matrix[row][col] + helper(row+1, col, n, m, matrix, dp);

        int lDiago = matrix[row][col] + helper(row+1, col-1, n, m, matrix, dp);

        int rDiago = matrix[row][col] + helper(row+1, col+1, n, m, matrix, dp);

        return dp[row][col] = Math.min(below, Math.min(lDiago, rDiago));
    }

    */
}