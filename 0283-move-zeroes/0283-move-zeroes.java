class Solution {
    public void moveZeroes(int[] nums) {
        
        int n = nums.length;

        int l = 0;

        while(l < n && nums[l] != 0) {
            l++;
        }

        if(l == n - 1) return;

        for(int i = l + 1; i < n; i++) {
            if(nums[i] != 0) {
                nums[l] = nums[i];
                nums[i] = 0;
                l++;
            }
        }
    }
}