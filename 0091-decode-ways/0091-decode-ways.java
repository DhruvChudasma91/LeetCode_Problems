class Solution {
    public int numDecodings(String s) {

        int n = s.length();

        if (s.charAt(0) == '0')
            return 0;

        int prev2 = 1;
        int prev1 = 1;


        for(int ind = 1; ind < n; ind++) {

            int single = 0;

            if(s.charAt(ind) != '0') {
                single = prev1;
            }

            int dual = 0;
            int num = (s.charAt(ind - 1) - '0') * 10 + (s.charAt(ind) - '0');

            if (num >= 10 && num <= 26) {

                if (ind == 1) {
                    dual = 1;
                } else {
                    dual = prev2;
                }
            }

            int curr = single + dual;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
        
    }

    /*

    public int helpar(int ind, String s, int[] dp) {

        if(ind < 0) {
            return 1;
        }

        if(dp[ind] != -1) return dp[ind];

        int single = 0;

        if(s.charAt(ind) != '0') {
            single = helpar(ind - 1, s, dp);
        }

        int dual = 0;

        if(ind >= 1) {

            int num = (s.charAt(ind - 1) - '0') * 10 + (s.charAt(ind) - '0');

            if(num >= 10 && num <= 26) {
                dual = helpar(ind - 2, s, dp);
            }
        }

        dp[ind] = single + dual;

        return single + dual;
    }

    */
}