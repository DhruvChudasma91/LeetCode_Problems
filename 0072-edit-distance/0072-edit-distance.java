class Solution {
    public int minDistance(String word1, String word2) {
        
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n][m];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }

        return findMinDistance(n-1, m-1, word1, word2, dp); 
    }

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
}