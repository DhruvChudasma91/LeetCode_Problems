class Solution {
public:
    bool isMatch(string s, string p) {

        /*
            BETRAYAL IS SURVIVAL, DEAR DHRUV.
        */

        int n = s.size();
        int m = p.size();

        vector<vector<bool>> dp(n + 1,
                                vector<bool>(m + 1, false));

        dp[0][0] = true;

        // Handle patterns like a*, a*b*, a*b*c*
        for (int j = 2; j <= m; j++) {
            if (p[j - 1] == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // Current characters match
                if (p[j - 1] == s[i - 1] || p[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // Current pattern character is '*'
                else if (p[j - 1] == '*') {

                    // Treat '*' as zero occurrences
                    if (j >= 2) {
                        dp[i][j] = dp[i][j - 2];

                        // Treat '*' as one or more occurrences
                        if (p[j - 2] == s[i - 1] ||
                            p[j - 2] == '.') {
                            dp[i][j] =
                                dp[i][j] || dp[i - 1][j];
                        }
                    }
                }
            }
        }

        return dp[n][m];
        
    }
};