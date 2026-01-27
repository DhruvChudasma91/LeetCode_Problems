class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if(entry.getValue() >= 2) {
                ans.add(entry.getKey());
            }
        }
        
        return ans;
    }
}