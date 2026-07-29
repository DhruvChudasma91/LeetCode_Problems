class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;

        Integer[][] dp = new Integer[n][m];

        int ans = (int)1e9;
        for(int i = 0; i < m; i++) {
            int sum = helper(0, i, n, m, matrix, dp);

            ans = Math.min(sum, ans);
        }

        return ans;
    }

    public int helper(int row, int col, int n, int m, int[][] matrix, Integer[][] dp) {

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
}