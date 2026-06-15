class Solution {
    public boolean isMatch(String s, String p) {
        
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        for(int i = 1; i <= n; i++) {
            dp[i][0] = false;
        }

        for(int j = 1; j <= m; j++) {
            dp[0][j] = isRemainingStars(j, p);
        }

        for(int i = 1; i <= n; i++) {

            for(int j = 1; j <= m; j++) {
                
                if(p.charAt(j - 1) == '?' || s.charAt(i-1) == p.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]; 
                } else if(p.charAt(j - 1) == '*'){
                    dp[i][j] = (dp[i][j-1] || dp[i-1][j]);
                } else {
                    dp[i][j] = false;
                }

            }
        }

        return dp[n][m];
        
    }

    public static boolean isRemainingStars(int ind, String p){

        for(int i = 1; i<=ind; i++) {

            if(p.charAt(i-1) != '*'){
                return false;
            }
        }

        return true;
    }

    /*

    public boolean wcm(int ind1, int ind2, String s, String p, int[][] dp) {

        if(ind2 < 0 && ind1 < 0) return true;

        if(ind2 < 0 && ind1 >= 0) return false;

        if(ind1 < 0 && ind2 >= 0) return isRemainingStars(ind2, p);

        if(dp[ind1][ind2] != -1) return (dp[ind1][ind2] == 1)? true : false;

        if(p.charAt(ind2) == '?' || s.charAt(ind1) == p.charAt(ind2)) {

            dp[ind1][ind2] = (wcm(ind1 - 1, ind2 - 1, s, p, dp))? 1 : 0;
            return (dp[ind1][ind2] == 1)? true : false;

        } else if(p.charAt(ind2) == '*') {

            dp[ind1][ind2] = ((wcm(ind1 - 1, ind2, s, p, dp) || wcm(ind1, ind2 - 1, s, p, dp)))? 1 : 0;

            return (dp[ind1][ind2] == 1)? true : false;
        }

        dp[ind1][ind2] = 0;

        return false;
    }

    */

}