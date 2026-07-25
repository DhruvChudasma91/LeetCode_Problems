class Solution {
    public int maxProduct(int n) {

        if(n == 10) return 0;
        
        int num = n;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        while(num > 0) {

            int digit = num % 10;

            if(digit > max1) {
                max2 = max1;
                max1 = digit;
            } else if(digit > max2) {
                max2 = digit;
            }

            num /= 10;
        }

        return max1 * max2;
    }
}