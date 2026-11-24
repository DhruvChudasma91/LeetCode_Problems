class Solution {
    public int pivotIndex(int[] nums) {
        
        int n = nums.length;
        int leftSum = 0;
        int rightSum = 0;

        for(int num : nums) {
            rightSum += num;
        }
 
        for(int i = 0; i < n; i++) {

            rightSum -= nums[i];

            if(leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];

        }

        return -1;
    }
}