class Solution {
    public int numDecodings(String s) {

        int n = s.length();
        int MOD = 1000000007;

        if(s.charAt(0) == '0') return 0;

        long[] dp = new long[n];
        dp[0] = waysSingle(s.charAt(0));

        for(int i = 1; i < n; i++) {

            long ans = 0;

            long single = waysSingle(s.charAt(i));
            ans = (ans + single * dp[i - 1]) % MOD;

            int dual = waysDouble(s.charAt(i-1), s.charAt(i));

            if(dual > 0) {

                if(i == 1) {
                    ans = (ans + dual) % MOD;
                } else {
                    ans = (ans + dual * dp[i-2]) % MOD;
                }
            }

            dp[i] = ans;
        }

        return (int) dp[n-1];
    }

    /*

    public int helpar(int ind, String s, int MOD, int[] dp) {

        if(ind < 0) {
            return 1;
        }

        if(dp[ind] != -1) return dp[ind];

        int ans = 0;

        int single = waysSingle(s.charAt(ind));

        ans = (int)((ans + (long)single * helpar(ind - 1, s, MOD, dp)) % MOD);

        if(ind >= 1) {

            int dual = waysDouble(s.charAt(ind-1), s.charAt(ind));

            ans = (int)((ans + (long)dual * helpar(ind - 2, s, MOD, dp)) % MOD);
        }

        return dp[ind] = ans % MOD;
    }

    */

    public int waysSingle(char ch) {

        if (ch == '0')
            return 0;

        if (ch == '*')
            return 9;

        return 1;
    }

    public int waysDouble(char first, char second) {

        if (first == '*' && second == '*') {
            return 15;
        }

        // *x
        if (first == '*') {

            if (second >= '0' && second <= '6')
                return 2;      // 10-16 or 20-26

            return 1;          // 17-19
        }

        // x*
        if (second == '*') {

            if (first == '1')
                return 9;      // 11-19

            if (first == '2')
                return 6;      // 21-26

            return 0;
        }

        // Normal digits
        int num = (first - '0') * 10 + (second - '0');

        return (num >= 10 && num <= 26) ? 1 : 0;
    }
}