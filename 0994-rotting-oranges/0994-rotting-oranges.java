class Solution {

    public int orangesRotting(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int freshOranges = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                } else if(grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if(freshOranges == 0) return 0;
        if(queue.isEmpty()) return -1;

        int minTime = -1;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!queue.isEmpty()) {

            int size = queue.size();
            minTime++;

            while(size-- > 0) {

                int[] cell = queue.remove();
                int x = cell[0];
                int y = cell[1];

                for(int[] d : dir) {

                    int newRow = x + d[0];
                    int newCol = y + d[1];

                    if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1 && visited[newRow][newCol] == false) {
                        visited[newRow][newCol] = true;
                        queue.add(new int[]{newRow, newCol});
                        freshOranges--;
                    }
                }
            }
        }

        if(freshOranges > 0) return -1;

        return minTime;

    }
}