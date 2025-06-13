class Solution {

    public int lengthOfLongestSubstring(String str) {
        int n = str.length();
        HashMap<Character, Integer> hm = new HashMap<>();

        int s = 0;
        int e = 0;
        int maxLen = 0;
        while(e < n)  {

            char ch = str.charAt(e);

            if(hm.containsKey(ch) && hm.get(ch) >= s) {
                s = hm.get(ch) + 1;
            }

            maxLen = Math.max(maxLen, e - s + 1);
            hm.put(ch, e);
            e++;
        }

        return maxLen;
    }
}