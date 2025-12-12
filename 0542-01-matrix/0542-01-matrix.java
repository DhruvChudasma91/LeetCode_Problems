class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;

        boolean[][] visited = new boolean[m][n];
        int[][] distance = new int[m][n];
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(mat[i][j] == 0) {
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()) {

            int[] cell = queue.remove();

            int row = cell[0];
            int col = cell[1];
            int dis = cell[2];

            distance[row][col] = dis;

            for(int[] dir : directions) {

                int x = row + dir[0];
                int y = col + dir[1];

                if(x >= 0 && y >= 0 && x < m && y < n && visited[x][y] == false) {

                    visited[x][y] = true;
                    queue.add(new int[]{x, y, dis + 1});
                }
            }
        }

        return distance;
    }
}