class Solution {
    public int removeDuplicates(int[] nums) {
        
        int n = nums.length;

        int p = 0;
        for(int i = 1; i < n; i++) {

            if(nums[i] != nums[p]) {
                p++;
                nums[p] = nums[i];
            } 
        }

        return p + 1;
        
    }
}