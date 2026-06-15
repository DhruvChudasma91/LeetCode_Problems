class Solution {
    public int minDistance(String word1, String word2) {
        
        int n = word1.length();
        int m = word2.length();

        int[] prev = new int[m+1];

        for(int i = 0; i <= m; i++) {
            prev[i] = i;
        }

        for(int i = 1; i <= n; i++) {

            int[] curr = new int[m+1];
            curr[0] = i;

            for(int j = 1; j <= m; j++) {

                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    curr[j] = prev[j-1]; //prev
                } else {

                    int insert = curr[j-1]; //curr
                    int delete = prev[j]; //prev
                    int replace = prev[j-1]; //prev

                    curr[j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }

            prev = curr.clone();
        }

        return prev[m];
    }

    /*

    public int findMinDistance(int ind1, int ind2, String word1, String word2, int[][] dp){

        if(ind1 < 0) return ind2 + 1;

        if(ind2 < 0) return ind1 + 1;

        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if(word1.charAt(ind1) == word2.charAt(ind2)) {
            return dp[ind1][ind2] = findMinDistance(ind1 - 1, ind2 - 1, word1, word2, dp);
        }

        int insert = 1 + findMinDistance(ind1, ind2 - 1, word1, word2, dp);
        int delete = 1 + findMinDistance(ind1 - 1, ind2, word1, word2, dp);
        int replace = 1 + findMinDistance(ind1 - 1, ind2 - 1, word1, word2, dp);

        return dp[ind1][ind2] = Math.min(insert, Math.min(delete, replace));
    }

    */
}