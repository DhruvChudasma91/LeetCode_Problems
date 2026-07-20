class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        List<List<Integer>> ans = new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                list.add(grid[i][j]);
            }
        }

        System.out.println(list);

        k = k % list.size();

        reverse(0, list.size()-1, list);
        reverse(0, k-1, list);
        reverse(k, list.size()-1, list);

        System.out.println(list);

        int ind = 0;
        int count = 0;
        while(ind < list.size()) {

            List<Integer> row = new ArrayList<>();
            while(count < n) {
                count++;
                row.add(list.get(ind));
                ind++;
            }

            if(count >= n) {
                count = 0;
                ans.add(row);
            }

            
        }

        return ans;
    }

    public void reverse(int s, int e, ArrayList<Integer> list) {

        while(s < e) {

            int temp = list.get(s);
            list.set(s, list.get(e));
            list.set(e, temp);
            s++;
            e--;
        }
    }
}