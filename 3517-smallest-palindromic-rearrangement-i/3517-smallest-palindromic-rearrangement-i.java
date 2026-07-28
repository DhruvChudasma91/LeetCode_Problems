class Solution {
    public String smallestPalindrome(String str) {
        
        int[] freq = new int[26];

        for (char ch : str.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        char middle = 0;

        for (int i = 0; i < 26; i++) {

            while (freq[i] >= 2) {
                left.append((char)(i + 'a'));
                freq[i] -= 2;
            }

            if (freq[i] == 1) {
                middle = (char)(i + 'a');
            }
        }

        StringBuilder ans = new StringBuilder();

        ans.append(left);

        if (middle != 0) {
            ans.append(middle);
        }

        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }
}