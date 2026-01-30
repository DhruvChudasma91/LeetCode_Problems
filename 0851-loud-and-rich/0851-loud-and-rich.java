class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] minQuiet = new int[n];
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            minQuiet[i] = -1;
        }

        for(int[] rich : richer) {
            adj.get(rich[1]).add(rich[0]);
        }

        for(int i = 0; i < n; i++) {
            dfs(i, adj, minQuiet, quiet); 
        }
        
        return minQuiet;
    }

    public int dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] minQuiet, int[] quiet) {

        if(minQuiet[node] != -1) {
            return minQuiet[node];
        }

        minQuiet[node] = node;

        for(int it : adj.get(node)) {

            int currQuietest = dfs(it, adj, minQuiet, quiet);

            if(quiet[currQuietest] < quiet[minQuiet[node]]) {
                minQuiet[node] = currQuietest;
            }
        }

        return minQuiet[node];
    }
}