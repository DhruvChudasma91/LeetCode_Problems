class Solution {
    public int orangesRotting(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int freshOranges = 0;

        for(int i = 0; i < n; i++) {

            for(int j = 0; j < m; j++) {

                if(grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }

                if(grid[i][j] == 1) freshOranges++;
            }
        }

        if(freshOranges == 0) return 0;
        if(queue.isEmpty()) return -1;
        
        int minTime = -1;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while(!queue.isEmpty()) {

            
            int size = queue.size();
            minTime++;

            while(size-- > 0) {

                int[] cell = queue.remove();
                int x = cell[0];
                int y = cell[1];
                
                for(int[] dir : directions) {

                    int i = x + dir[0];
                    int j = y + dir[1];

                    if(i >= 0 && i < n && j >= 0 && j < m && grid[i][j] == 1 && visited[i][j] == false) {

                        visited[i][j] = true;
                        queue.add(new int[]{i, j});
                        freshOranges--;
                    }
                }
            }
        }

        if(freshOranges > 0) return -1;

        return minTime;
    }
}