class Solution {
    public int minPathSum(int[][] grid) {
        
        //Space Optimization
        int n = grid.length;
        int m = grid[0].length;

        int[] prev = new int[m];
        prev[0] = grid[0][0];

        for(int row = 0; row < n; row++) {

            int[] curr = new int[m];
            for(int col = 0; col < m; col++) {

                if(row == 0 && col == 0) {
                    curr[0] = grid[0][0];
                    continue;
                }

                int left = (int)1e9;
                int up = (int)1e9;

                if(col > 0) {
                    left = grid[row][col] + curr[col-1];
                }

                if(row > 0) {
                    up = grid[row][col] + prev[col];
                }

                curr[col] = Math.min(left, up);
            }

            prev = curr.clone();
        }
        
        return prev[m-1];
    }


    /*

    public int tebulation(int[][] grid) {
    
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        dp[0][0] = grid[0][0];

        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {

                if(row == 0 && col == 0) continue;

                int left = (int)1e9;
                int up = (int)1e9;

                if(col > 0) {
                    left = grid[row][col] + dp[row][col-1];
                }

                if(row > 0) {
                    up = grid[row][col] + dp[row-1][col];
                }

                dp[row][col] = Math.min(left, up);
            }
        }
        
        return dp[n-1][m-1];
    
    
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

    */
}