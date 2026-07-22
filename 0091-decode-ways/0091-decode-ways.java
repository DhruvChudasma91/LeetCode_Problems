class Solution {
    public int numDecodings(String s) {

        int n = s.length();

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return helpar(n - 1, s, dp);
        
    }

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
}