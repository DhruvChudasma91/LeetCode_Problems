class Solution {
    public int minCut(String s) {
        
        int n = s.length();

        int[] dp = new int[n+1];
        dp[n] = -1;

        for(int f = n - 1; f >= 0; f--) {

            int min = (int)1e9;
            for(int last = f; last < n; last++) {

                if(isPalindrome(f, last, s)) {
                    
                    int cut = 1 + dp[last + 1];
                    min = Math.min(min, cut);
                } 
            }
            
            dp[f] = min;
        }

        return dp[0];
    }

    // public int helpar(int first, String s, int[] dp) {
        
    //     if(first == s.length() || isPalindrome(first, s.length() - 1, s)) {
    //         return 0;
    //     }

    //     if(dp[first] != -1) return dp[first];

    //     int min = (int)1e9;

    //     for(int last = first; last < s.length(); last++) {

    //         if(isPalindrome(first, last, s)) {
                
    //             int cut = 1 + helpar(last + 1, s, dp);
    //             min = Math.min(min, cut);
    //         } 
    //     }

    //     return dp[first] = min;
    // }

    public boolean isPalindrome(int l, int r, String s) {

        while(l < r) {

            if(s.charAt(l) != s.charAt(r)) {
                return false;
            } else {
                l++;
                r--;
            }
        }

        return true;
    }
}