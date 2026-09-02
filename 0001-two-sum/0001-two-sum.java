class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] ans = new int[2];

        for(int i = 0; i < n; i++) {

            if(hm.containsKey(target - nums[i])) {
                ans[0] = hm.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }

            hm.put(nums[i], i);
        }

        return ans;
    }
}