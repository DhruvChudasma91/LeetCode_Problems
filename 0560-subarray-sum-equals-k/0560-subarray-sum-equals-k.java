class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int preSum = 0;
        int count = 0;

        for(int i = 0; i < n; i++) {

            preSum += nums[i];

            if(preSum == k) {
                count++;
            }

            if(map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }

            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return count;

    }
}