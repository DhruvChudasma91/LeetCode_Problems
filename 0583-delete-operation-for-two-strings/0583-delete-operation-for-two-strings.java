class Solution {
    public int minDistance(String word1, String word2) {
        
        int n1 = word1.length();
        int n2 = word2.length();

        int needToRemove = n1 - lcs(word1, word2);
        int needToAdd = n2 - lcs(word1, word2);

        return needToRemove + needToAdd;
    }

    public int lcs(String text1, String text2){

        int n1 = text1.length();
        int n2 = text2.length();

        int[] dp = new int[n2+1];

        for(int ind1 = 1; ind1 <= n1; ind1++) {

            int[] curr = new int[n2+1];

            for(int ind2 = 1; ind2 <= n2; ind2++) {

                if(text1.charAt(ind1 - 1) == text2.charAt(ind2 - 1)) {
                    curr[ind2] = 1 + dp[ind2-1];
                } else {
                    curr[ind2] = Math.max(dp[ind2], curr[ind2-1]);
                }
            }

            dp = curr.clone();
        }

        return dp[n2];
    }
}