class Solution {
    public String smallestSubsequence(String s) {

        int n = s.length();
        Stack<Character> st = new Stack<>();
        boolean[] visited = new boolean[26];
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }

        for(int i = 0; i < n; i++) {
            
            char ch = s.charAt(i);

            if(!visited[ch - 'a']){

                if(st.isEmpty() || ch > st.peek()) {
                    st.push(ch);
                } else {

                    while(!st.isEmpty() && st.peek() > ch && map.get(st.peek()) > i) {
                        char remove = st.pop();
                        visited[remove - 'a'] = false;
                    }

                    st.push(ch);
                }

                visited[ch - 'a'] = true;
            }
        }

        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()) {
            char ch = st.pop();
            ans.insert(0, ch);
        }

        return ans.toString();
        
    }
}