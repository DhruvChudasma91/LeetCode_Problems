class Solution {

    public void dfs(int i, int j, char[][] temp, int m, int n) {
        if(i < 0 || j < 0 || i >= m || j >= n || temp[i][j] != '1') {
            return;
        }

        temp[i][j] = '0';
        
        dfs(i - 1, j, temp, m, n);
        dfs(i + 1, j, temp, m, n);
        dfs(i, j + 1, temp, m, n);
        dfs(i, j - 1, temp, m, n);
    }

    public int numIslands(char[][] grid) {
       
       int m = grid.length;
       int n = grid[0].length;
       char[][] temp = grid;
       int numIsland = 0;

       for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(temp[i][j] == '1') {
                    dfs(i, j, temp, m, n);
                    numIsland++;
                }
            }
       }

       return numIsland;
    }
}