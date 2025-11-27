class Solution {

    public int findMaxArea(int row, int col, int[][] temp, int m, int n) {

        if(row < 0 || col < 0 || row >= m || col >= n || temp[row][col] != 1) {
            return 0;
        }

        temp[row][col] = 0;

        int up = findMaxArea(row - 1, col, temp, m, n);
        int right = findMaxArea(row, col + 1, temp, m, n);
        int bottom = findMaxArea(row + 1, col, temp, m, n);
        int left = findMaxArea(row, col - 1, temp, m, n);

        int currentArea = up + right + bottom + left + 1;

        return currentArea;
    }

    public int maxAreaOfIsland(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int[][] temp = grid;

        int maxArea = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(temp[i][j] == 1) {

                    int area = findMaxArea(i, j, temp, m, n);
                    if(maxArea <= area) {
                        maxArea = area;
                    }
                }   
            }
        }
        
        return maxArea ;
    }
}