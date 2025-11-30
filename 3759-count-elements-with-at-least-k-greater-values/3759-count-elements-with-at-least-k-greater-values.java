class Solution {
    public int countElements(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return 0;
        if(k == 0) return n;

        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());

        for(int it : nums) {
            map.put(it, map.getOrDefault(it, 0) + 1);
        }

        int currLarger = 0;
        int qualifiedNums = 0;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int ele = entry.getKey();
            int count = entry.getValue();

            if(currLarger >= k) {
                qualifiedNums += count;
            }

            currLarger += count;
        }

        return qualifiedNums;
    }
}