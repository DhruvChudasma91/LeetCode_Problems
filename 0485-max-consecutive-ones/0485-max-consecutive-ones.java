class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int n = nums.length;

        int max = 0;
        int count = 0;

        for(int num : nums) {

            if(num == 1) {
                count++;
                if(count > max) {
                    max = count;
                }
            } else {
                count = 0;
            }
        }
        
        return max;
    }
}