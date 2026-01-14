import java.util.*;

class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int allVisited = (1 << n) - 1; // bitmask when all nodes are visited

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[n][1 << n];

        // Initialize BFS from every node
        for (int i = 0; i < n; i++) {
            int mask = 1 << i;
            queue.offer(new int[]{i, mask, 0}); // {currentNode, visitedMask, steps}
            seen[i][mask] = true;
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int mask = curr[1];
            int steps = curr[2];

            // If all nodes visited
            if (mask == allVisited) {
                return steps;
            }

            // Visit all neighbors
            for (int neighbor : graph[node]) {
                int nextMask = mask | (1 << neighbor);
                if (!seen[neighbor][nextMask]) {
                    seen[neighbor][nextMask] = true;
                    queue.offer(new int[]{neighbor, nextMask, steps + 1});
                }
            }
        }

        return -1; // just a fallback, graph is connected so this won't happen
    }
}