class Solution {
    public int numSquares(int n) {

        ArrayList<Integer> list = findPerSqrt(n);
        int len = list.size();

        int[] prev = new int[n+1];
        
        for (int target = 0; target <= n; target++) {
            if (target % list.get(0) == 0) {
                prev[target] = target / list.get(0);
            } else {
                prev[target] = (int) 1e9;
            }
        }

        for (int ind = 1; ind < len; ind++) {

            int[] curr = new int[n+1];
            for (int target = 1; target <= n; target++) {

                int notPick = prev[target];

                int pick = (int) 1e9;
                if (target >= list.get(ind)) {
                    pick = 1 + curr[target - list.get(ind)];
                }

                curr[target] = Math.min(notPick, pick);
            }

            prev = curr.clone();
        }

        return prev[n];
    }

    public ArrayList<Integer> findPerSqrt(int n) {

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 1; i * i <= n; i++) {
            list.add(i * i);
        }

        return list;
    }

    /*

    public int helpar(int ind, int target, ArrayList<Integer> list, int[][] dp) {

        if(target == 0) {
            return 0;
        }

        if(ind == 0) {

            if(target % list.get(ind) == 0) {
                return target / list.get(ind);
            } else {
                return (int)1e9;
            }
        }

        if(dp[ind][target] != -1) return dp[ind][target];

        int skip = helpar(ind - 1, target, list, dp);

        int pick = (int)1e9;
        if(list.get(ind) <= target) {
            pick = 1 + helpar(ind, target - list.get(ind), list, dp);
        }

        return dp[ind][target] = Math.min(skip, pick);
    }

    */
}