class Solution {
    public int longestPalindrome(String s) {
        int oddCount = 0;
        int[] freq = new int[128];

        for (char ch : s.toCharArray()) {
            freq[ch]++;
            if (freq[ch] % 2 == 1)
                oddCount++;
            else
                oddCount--;
        }

        if (oddCount > 1)
            return s.length() - oddCount + 1;
        return s.length();
    }
}