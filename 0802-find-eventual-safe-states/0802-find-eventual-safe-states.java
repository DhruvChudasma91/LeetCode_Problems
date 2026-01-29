class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        ArrayList<ArrayList<Integer>> revGraph = new ArrayList<>();
        int[] indegree = new int[V];

        for(int i = 0; i < V; i++) {
            revGraph.add(new ArrayList<>());
        }

        for(int i = 0; i < V; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                revGraph.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {

            int node = queue.remove();
            safeNodes.add(node);

            for(int it : revGraph.get(node)) {
                indegree[it]--;

                if(indegree[it] == 0) {
                    queue.add(it);
                }
            }
        }

        Collections.sort(safeNodes);

        return safeNodes;
         
    }
}