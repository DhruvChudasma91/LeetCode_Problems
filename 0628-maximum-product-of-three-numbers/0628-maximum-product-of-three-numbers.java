class Solution {
    public int maximumProduct(int[] nums) {
        
        int n = nums.length;

        int max1 = -1000;
        int max2 = -1000;
        int max3 = -1000;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int num : nums) {

            if(num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if(num > max2) {
                max3 = max2;
                max2 = num;
            } else if(num > max3) {
                max3 = num;
            }

            if(num < 0 && min1 > num) {
                min2 = min1;
                min1 = num;
            } else if(num < 0 && min2 > num) {
                min2 = num;
            }

            System.out.println(num);
            System.out.println("max1: " + max1 + " max2: " + max2 + " max3: " + max3);
            System.out.println("min1: " + min1 + " min2: " + min2);
        }

        if(min1 != Integer.MAX_VALUE && min2 != Integer.MAX_VALUE) {
            return Math.max(max1 * max2 * max3, min1 * min2 * max1);
        }

        return max1 * max2 * max3;
    }
}