class Solution {
    public int[][] merge(int[][] intervals) {

        int m = intervals.length;

        List<int[]> ans = new ArrayList<>();
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int lower = intervals[0][0];
        int upper = intervals[0][1];
        
        for(int i = 1; i < m; i++) {

            if(upper >= intervals[i][0]) {
                upper = Math.max(upper, intervals[i][1]);
            } else {

                int[] temp = {lower, upper};
                ans.add(temp);

                lower = intervals[i][0];
                upper = intervals[i][1];
            }
        }

        ans.add(new int[]{lower, upper});

        //System.out.println(ans);

        return ans.toArray(new int[ans.size()][]);
        
    }
}