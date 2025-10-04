class Solution {

    public void dfs(int row, int col, int[][] ans, int[][] image, int color, int intialColour, int[][] dir, int n, int m) {
        
        ans[row][col] = color;

        for(int[] d : dir) {

            int x = row + d[0];
            int y = col + d[1];

            if(x >= 0 && x < n && y >= 0 && y < m && image[x][y] == intialColour && ans[x][y] != color) {
                dfs(x, y, ans, image, color, intialColour, dir, n, m);
            }
        } 
    }


    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int intialColour = image[sr][sc];
        int[][] ans = image;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        dfs(sr, sc, ans, image, color, intialColour, dir, n, m);

        return ans;
    }
}