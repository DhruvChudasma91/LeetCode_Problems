class Solution {
    public void moveZeroes(int[] nums) {
        
        int n = nums.length;

        int l = -1;

        for(int i = 0; i < n; i++) {

            if(nums[i] != 0) {
                l++;

                if(nums[l] == 0) {
                    nums[l] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }
}