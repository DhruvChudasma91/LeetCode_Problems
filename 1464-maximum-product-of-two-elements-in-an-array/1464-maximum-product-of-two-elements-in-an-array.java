class Solution {
    public int maxProduct(int[] nums) {
        
        int n = nums.length;

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for(int num : nums) {

            if(num > max1) {
                max2 = max1;
                max1 = num;
            } else if(num > max2) {
                max2 = num;
            }
        }

        max1--;
        max2--;

        return max1 * max2;

    }
}