class Solution {

    public boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited) {

        visited[node] = true;
        pathVisited[node] = true;

        for(int it : adj.get(node)) {

            if(visited[it] == false) {
                if(dfs(it, adj, visited, pathVisited)) {
                    return true;
                } 
            } else if(pathVisited[it]) {
                return true;
            }
        }

        pathVisited[node] = false;

        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j= 0; j < graph[i].length; j++) {
                list.add(graph[i][j]);
            }
            adj.add(list);
        }

        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(visited[i] == false) {
                dfs(i, adj, visited, pathVisited);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(pathVisited[i] == false) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }
}