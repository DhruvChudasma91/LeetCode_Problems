class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;
        int size = m * n;

        k %= size;

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {

                // Current flattened index in result
                int newIndex = i * n + j;

                // Find corresponding old index
                int oldIndex = (newIndex - k + size) % size;

                // Convert flattened index back to grid coordinates
                int oldRow = oldIndex / n;
                int oldCol = oldIndex % n;

                row.add(grid[oldRow][oldCol]);
            }

            ans.add(row);
        }

        return ans;
        
    }
}