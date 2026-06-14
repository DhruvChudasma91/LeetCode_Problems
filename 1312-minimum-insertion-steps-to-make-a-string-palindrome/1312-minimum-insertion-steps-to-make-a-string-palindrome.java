class Solution {
    public int minInsertions(String s) {
        
        int n = s.length();

        return n - longestPalindromeSubseq(s);
    }

    public int longestPalindromeSubseq(String s) {
        
        int n = s.length();

        StringBuilder sb = new StringBuilder();
        for(int i = n-1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        String t = sb.toString();

        return findLPS(s, t, n);
    }

    public int findLPS(String s, String t, int n){

        int[] dp = new int[n+1];

        for(int ind1 = 1; ind1 <= n; ind1++) {

            int[] curr = new int[n+1];
            for(int ind2 = 1; ind2 <= n; ind2++) {

                if(s.charAt(ind1 - 1) == t.charAt(ind2 - 1)){
                    curr[ind2] = 1 + dp[ind2 - 1];
                } else {
                    curr[ind2] = Math.max(dp[ind2], curr[ind2 -1]);
                }
            }

            dp = curr.clone();
        }

        return dp[n];
    }
}