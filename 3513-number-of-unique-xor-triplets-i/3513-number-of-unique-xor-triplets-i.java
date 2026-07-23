class Solution {
    public int uniqueXorTriplets(int[] nums) {

        int n = nums.length;

        if(n <= 2) {
            return n;
        }

        
        int temp = n;
        int countBits = 0;
        while(temp > 0) {
            temp = temp >> 1;
            countBits++;
        }

        int ans = (int) Math.pow(2, countBits);

        return ans;
        
    }
}