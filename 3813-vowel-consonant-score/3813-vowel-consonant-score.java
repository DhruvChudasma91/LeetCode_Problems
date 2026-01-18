class Solution {
    public int vowelConsonantScore(String s) {

        int n = s.length();
        int v = 0;
        int c = 0;

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if((ch >= '0' && ch <= '9') || ch == ' ') {
                continue;
            }
            
            if(ch =='a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                v++;
            } else {
                c++;
            }
        }

        int score = 0;
        if(c > 0) score = v / c;

        return score;
    }
}