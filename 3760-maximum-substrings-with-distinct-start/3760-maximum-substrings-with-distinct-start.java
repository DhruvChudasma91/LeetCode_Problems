class Solution {
    public int maxDistinct(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            set.add(ch);
        }

        return set.size();
        
    }
}