class Solution {
    public void dfs(int i, int[][] isConnected, boolean[] visited) {

        visited[i] = true;

        for(int j = 0; j < isConnected[i].length; j++) {

            if(isConnected[i][j] == 1 && visited[j] == false) {
                dfs(j, isConnected, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[v];

        for(int i = 0; i < v; i++) {

            if(visited[i] == false) {
                dfs(i, isConnected, visited);
                count++;
            }
        }

        return count;
    }
}