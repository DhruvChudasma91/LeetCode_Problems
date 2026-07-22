class Solution {
    public int numSquares(int n) {

        ArrayList<Integer> list = findPerSqrt(n);
        int len = list.size();

        int[][] dp = new int[len][n+1];
        
        for (int target = 0; target <= n; target++) {
            if (target % list.get(0) == 0) {
                dp[0][target] = target / list.get(0);
            } else {
                dp[0][target] = (int) 1e9;
            }
        }

        for (int ind = 1; ind < len; ind++) {
            for (int target = 0; target <= n; target++) {

                int notPick = dp[ind - 1][target];

                int pick = (int) 1e9;
                if (target >= list.get(ind)) {
                    pick = 1 + dp[ind][target - list.get(ind)];
                }

                dp[ind][target] = Math.min(notPick, pick);
            }
        }

        return dp[len-1][n];
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