class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int m = image.length;
        int n = image[0].length;

        int[][] ans = image;
        int intialColor = image[sr][sc];

        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        dfs(sr, sc, image, ans, dir, intialColor, color, m, n);

        return ans;
    }

    public void dfs(int row, int column, int[][] image, int[][] ans, int[][] dir, int intialColor, int color, int m, int n) {

        ans[row][column] = color;

        for(int[] d : dir) {

            int x = row + d[0];
            int y = column + d[1];

            if(x >= 0 && x < m && y >= 0 && y < n && image[x][y] == intialColor && ans[x][y] != color) {
                dfs(x, y, image, ans, dir, intialColor, color, m, n);
            }
        }
    }
}