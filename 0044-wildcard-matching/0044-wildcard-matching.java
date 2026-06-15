class Solution {
    public boolean isMatch(String s, String p) {
        
        int n = s.length();
        int m = p.length();

        int[][] dp = new int[n][m];
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return wcm(n-1, m-1, s, p, dp);
        
    }

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

    public boolean isRemainingStars(int ind, String p){

        for(int i = ind; i>=0; i--) {

            if(p.charAt(i) != '*'){
                return false;
            }
        }

        return true;
    }
}