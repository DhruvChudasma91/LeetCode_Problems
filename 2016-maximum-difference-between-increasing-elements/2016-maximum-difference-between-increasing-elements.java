class Solution {
    public int maximumDifference(int[] nums) {
        
        int n = nums.length;
        int minEle = nums[0];
        int maxDiff = -1;

        for(int i = 1; i < n; i++) {

            if(nums[i] > minEle) {

                maxDiff = Math.max(maxDiff, nums[i] - minEle);
            }

            if(nums[i] < minEle){
                minEle = nums[i];
            }

        }

        return maxDiff;
        
    }
}