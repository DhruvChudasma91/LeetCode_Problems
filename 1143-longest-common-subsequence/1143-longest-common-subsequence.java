class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        return findLCS(text1, text2);       
        
    }

    public int findLCS(String text1, String text2){

        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[n1+1][n2+1];

        for(int ind1 = 1; ind1 <= n1; ind1++) {

            for(int ind2 = 1; ind2 <= n2; ind2++) {

                if(text1.charAt(ind1 - 1) == text2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                } else {
                    dp[ind1][ind2] = Math.max(dp[ind1-1][ind2], dp[ind1][ind2-1]);
                }
            }
        }

        return dp[n1][n2];
    }
}