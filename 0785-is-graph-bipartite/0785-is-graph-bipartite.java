class Solution {

    public boolean dfs(int node, int set, int[] visited, int[][] graph) {

        visited[node] = set;

        for(int i = 0; i < graph[node].length; i++) {
            
            if(visited[graph[node][i]] == -1) {

                if(dfs(graph[node][i], 1 - set, visited, graph) == false) {
                    return false;
                }
            }
            
            else if(visited[graph[node][i]] == set ) {
                return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int[] visited = new int[n];
        for(int i = 0; i < n; i++) visited[i] = -1;

        for(int i = 0; i < n; i++) {

            if(visited[i] == -1) {
                if(dfs(i, 0, visited, graph) == false) {
                    return false;
                }
            }
        }

        return true;
    }
}