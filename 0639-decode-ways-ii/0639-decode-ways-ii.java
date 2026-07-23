class Solution {
    public int numDecodings(String s) {

        int n = s.length();
        int MOD = 1000000007;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return helpar(n-1, s, MOD, dp);
    }

    public int helpar(int ind, String s, int MOD, int[] dp) {

        if(ind < 0) {
            return 1;
        }

        if(dp[ind] != -1) return dp[ind];

        int single = 0;

        if(s.charAt(ind) != '0') {

            if(s.charAt(ind) == '*') {

                for(int i = 1; i <= 9; i++) {
                    single = (single + helpar(ind - 1, s, MOD, dp)) % MOD;
                }
            } else {
                single = helpar(ind - 1, s, MOD, dp);
            }
        } 

        int dual = 0;
        if(ind >= 1) {

            if(s.charAt(ind) == '*') {

                for(int i = 1; i <= 9; i++) {

                    if(s.charAt(ind - 1) != '*') {
                        int num = (s.charAt(ind - 1) - '0') * 10 + i;

                        if(num >= 10 && num <= 26) {
                            dual = (dual + helpar(ind - 2, s, MOD, dp)) % MOD;
                        }
                    } else {

                        for(int j = 1; j <= 9; j++) {

                            int num = j * 10 + i;

                            if(num >= 10 && num <= 26) {
                                dual = (dual + helpar(ind - 2, s, MOD, dp)) % MOD;
                            }
                        }
                    }
                }

            } else {

                if(s.charAt(ind - 1) == '*') {

                    for(int k = 1; k <= 9; k++) {

                        int num = k * 10 + (s.charAt(ind) - '0');

                        if(num >= 10 && num <= 26) {
                            dual = (dual + helpar(ind - 2, s, MOD, dp)) % MOD;
                        }
                    } 
                } 

                else {
                    int num = (s.charAt(ind - 1) - '0') * 10 + (s.charAt(ind) - '0');

                    if(num >= 10 && num <= 26) {
                        dual = helpar(ind - 2, s, MOD, dp);
                    }
                }
            }
        }

        dp[ind] = (single + dual) % MOD;

        return (single + dual) % MOD;
    }
}