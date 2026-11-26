class Solution {
    public boolean check(int[] nums) {
        
        int n = nums.length;
        boolean condition = false;

        for(int i = 0; i < n; i++) {

            if(nums[i] > nums[(i + 1) % n]) {

                if(condition) return false;

                condition = true;
            }
        }

        return true;
    }
}