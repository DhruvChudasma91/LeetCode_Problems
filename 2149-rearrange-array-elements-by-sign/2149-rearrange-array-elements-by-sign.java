class Solution {
    public int[] rearrangeArray(int[] nums) {

        int len = nums.length;

        int[] ans = new int[len];

        int p = 0;
        int n = 1;

        for(int i = 0; i < len; i++) {

            if(nums[i] > 0) {
                ans[p] = nums[i];
                p += 2;
            } else {
                ans[n] = nums[i];
                n += 2;
            }
        }

        return ans;
        
    }
}