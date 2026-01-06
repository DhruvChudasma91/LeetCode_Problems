class Pair {

    String word;
    int level;

    Pair(String word, int level) {
        this.word = word;
        this.level = level;
    }
}



class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();

        for(String str : wordList) {
            set.add(str);
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        while(!queue.isEmpty()) {

            Pair curr = queue.remove();
            String currWord = curr.word;
            int currLevel = curr.level;

            if(currWord.equals(endWord)) return currLevel;

            for(int i = 0; i < currWord.length(); i++) {

                for(char j = 'a'; j <= 'z'; j++) {

                    char[] wordArray = currWord.toCharArray();
                    wordArray[i] = j;
                    String newWord = new String(wordArray);

                    if(set.contains(newWord)) {
                        queue.add(new Pair(newWord, currLevel + 1));
                        set.remove(newWord);
                    }

                }
            }
        }

        return 0;
        
    }
}