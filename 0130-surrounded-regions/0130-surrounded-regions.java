class Solution {
    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {

            for(int j = 0; j < n; j++) {

                if((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {

                    bfs(i, j, board, visited, m, n);
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(board[i][j] == 'O' && visited[i][j] == false) {
                    board[i][j] = 'X';
                }
            }
        }  
    }

    public void bfs(int i, int j, char[][] board, boolean[][] visited, int m, int n) {

        Queue<int[]> queue = new LinkedList<>();
        visited[i][j] = true;
        queue.add(new int[]{i, j});

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!queue.isEmpty()) {

            int[] cell = queue.remove();
            int row = cell[0];
            int col = cell[1];

            for(int[] dir : directions) {

                int x = row + dir[0];
                int y = col + dir[1];

                if(x >= 0 && y >= 0 && x < m && y < n && board[x][y] == 'O' && visited[x][y] == false) {
                    visited[x][y] = true;
                    queue.add(new int[]{x, y});
                }
            }
        }

    }
}