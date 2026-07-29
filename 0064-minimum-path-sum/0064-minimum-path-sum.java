class Solution {
    public int minPathSum(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        for(int [] d : dp){
            Arrays.fill(d, -1);
        }

        return helper(n-1, m-1, grid, dp);
    }

    public int helper(int row, int col, int[][] grid, int[][] dp) {

        if(row < 0 || col < 0) {
            return (int)1e9;
        }

        if(row == 0 && col == 0) {
            return grid[0][0];
        }

        if(dp[row][col] != -1) return dp[row][col];


        int left = grid[row][col] + helper(row, col-1, grid, dp);

        int up = grid[row][col] + helper(row - 1, col, grid, dp);

        return dp[row][col] = Math.min(left, up);
    }
}