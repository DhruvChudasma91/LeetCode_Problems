class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);

        // 1. Basic checks
        if (!wordSet.contains(endWord)) {
            return result; // endWord must be in the wordList
        }

        // Map to store predecessors for building paths (child -> list of parents)
        // Example: If "hot" -> "dot" is a shortest path, adj.get("dot") would contain "hot"
        Map<String, List<String>> adj = new HashMap<>();

        // Map to store the shortest distance from beginWord to each word
        Map<String, Integer> distance = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0); // beginWord is at distance 0 from itself

        boolean endFound = false; // Flag to indicate if endWord has been reached

        // Phase 1: BFS to build the graph of shortest paths and find minimum distance
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // This set will store words visited in the current level.
            // These words will be removed from wordSet AFTER this level is processed
            // to prevent revisiting them from later levels via longer paths.
            Set<String> wordsVisitedThisLevel = new HashSet<>(); 

            for (int i = 0; i < levelSize; i++) {
                String currentWord = queue.poll();

                // Generate all possible next words by changing one character
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] charArray = currentWord.toCharArray();
                    char originalChar = charArray[j]; // Store original char to restore later

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue; // No change, skip
                        charArray[j] = c;
                        String nextWord = new String(charArray);

                        // If nextWord is a valid word from the dictionary
                        if (wordSet.contains(nextWord)) {
                            // Case 1: nextWord is discovered for the first time
                            if (!distance.containsKey(nextWord)) {
                                distance.put(nextWord, distance.get(currentWord) + 1);
                                queue.offer(nextWord);
                                wordsVisitedThisLevel.add(nextWord); // Mark for removal from wordSet
                                
                                // Add currentWord as a predecessor for nextWord
                                adj.computeIfAbsent(nextWord, k -> new ArrayList<>()).add(currentWord);

                                if (nextWord.equals(endWord)) {
                                    endFound = true; // endWord found at this level
                                }
                            } 
                            // Case 2: nextWord was already discovered, but we found another shortest path to it
                            // (i.e., it's at the same distance from beginWord as currentWord + 1)
                            else if (distance.get(nextWord) == distance.get(currentWord) + 1) {
                                adj.computeIfAbsent(nextWord, k -> new ArrayList<>()).add(currentWord);
                            }
                        }
                    }
                    charArray[j] = originalChar; // Restore original char for the next iteration
                }
            }
            
            // After processing all words in the current level, remove them from wordSet.
            // This is crucial: it prevents words from being revisited in deeper levels, 
            // ensuring we only consider shortest paths. Any word in wordsVisitedThisLevel 
            // has now been reached by a shortest path from beginWord, so we don't need 
            // to find a longer path to it.
            wordSet.removeAll(wordsVisitedThisLevel);

            if (endFound) {
                break; // Stop BFS as soon as endWord is found, because we want shortest paths
            }
        }

        // If endWord was not reachable during BFS, return an empty list
        if (!endFound) {
            return result;
        }

        // Phase 2: DFS to reconstruct all shortest paths using the 'adj' map
        LinkedList<String> currentPath = new LinkedList<>();
        // We start DFS from endWord and backtrack to beginWord
        dfs(endWord, beginWord, adj, distance, currentPath, result);

        return result;
    }

    /**
     * Recursive DFS function to reconstruct all shortest paths.
     * It builds the path by adding words to the front (LinkedList.addFirst)
     * as it traverses from endWord back to beginWord.
     */
    private void dfs(String currentWord, String beginWord, Map<String, List<String>> adj,
                     Map<String, Integer> distance, LinkedList<String> currentPath, List<List<String>> result) {
        
        // Add the current word to the front of the path (since we're building backward)
        currentPath.addFirst(currentWord);

        // Base case: if we reached beginWord, we found a complete shortest path
        if (currentWord.equals(beginWord)) {
            result.add(new ArrayList<>(currentPath)); // Add a copy of the path to results
        } 
        // Recursive step: explore predecessors
        else if (adj.containsKey(currentWord)) {
            for (String prevWord : adj.get(currentWord)) {
                // IMPORTANT: Only follow predecessors that are on a shortest path.
                // This means the distance of the current word must be exactly 1 more than its predecessor.
                if (distance.get(currentWord) == distance.get(prevWord) + 1) {
                    dfs(prevWord, beginWord, adj, distance, currentPath, result);
                }
            }
        }
        
        // Backtrack: remove the current word to explore other paths
        currentPath.removeFirst();
    }
}