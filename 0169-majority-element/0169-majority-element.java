class Solution {
    public int majorityElement(int[] nums) {
        
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        int maxFreq = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {

            if(maxFreq <= entry.getValue()) {
                maxFreq = entry.getValue();
                ans = entry.getKey();
            }
        }

        return ans;
    }
}