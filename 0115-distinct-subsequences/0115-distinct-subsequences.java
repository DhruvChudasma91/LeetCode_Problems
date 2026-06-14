class Solution {
    public int numDistinct(String s, String t) {

        int n1 = s.length();
        int n2 = t.length();

        int[][] dp = new int[n1+1][n2+1];

        for(int j = 0; j <= n1; j++) {
            dp[j][0] = 1;
        }

        for(int i = 1; i <= n1; i++) {

            for(int j = 1; j <= n2; j++) {

                if(s.charAt(i - 1) == t.charAt(j - 1)) {

                    int notPick = dp[i-1][j];
                    int pick = dp[i-1][j-1];

                    dp[i][j] = notPick + pick;
                } else {

                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n1][n2];
    }

    /*
    public int findDS(int ind1, int ind2, String s, String t, int[][] dp) {

        if(ind2 < 0){
            return 1;
        } 

        if(ind1 < 0) {
            return 0;
        }

        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if(s.charAt(ind1) == t.charAt(ind2)) {

            int notPick = findDS(ind1 - 1, ind2, s, t, dp);
            int pick = findDS(ind1 - 1, ind2  - 1, s, t, dp);
            return dp[ind1][ind2] = notPick + pick;
        } 

        return dp[ind1][ind2] = findDS(ind1 - 1, ind2, s, t, dp);
    }
    */
}