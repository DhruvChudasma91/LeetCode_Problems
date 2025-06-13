class Solution {
    public int findLHS(int[] nums) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int it : nums) {
            hm.put(it, hm.getOrDefault(it, 0) + 1);
        }

        int maxLen = 0;
        for(int it : hm.keySet()) {

            if(hm.containsKey(it + 1)) {

                int currLen = hm.get(it) + hm.get(it + 1);
                maxLen = Math.max(maxLen, currLen);
            }
        }

        return maxLen;
    }
}