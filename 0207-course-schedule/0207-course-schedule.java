class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        int completed = 0;
        while(!queue.isEmpty()) {

            int node = queue.remove();
            completed++;

            for(int it : adj.get(node)) {

                indegree[it]--;

                if(indegree[it] == 0) {
                    queue.add(it);
                }
            }

        }

        return completed == numCourses;
    }
}