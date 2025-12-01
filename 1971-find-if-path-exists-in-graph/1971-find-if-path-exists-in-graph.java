class Solution {

    public boolean isPath(int n, int dest, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {

        if(n == dest) return true;

        visited[n] = true;
        boolean flag = false;

        for(int it : adj.get(n)) {

            if(visited[it] == false) {
                flag = isPath(it, dest, adj, visited);
            }

            if(flag == true) return true;
        }

        return flag;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean ans = isPath(source, destination, adj, visited);
        
        return ans;
    }
}