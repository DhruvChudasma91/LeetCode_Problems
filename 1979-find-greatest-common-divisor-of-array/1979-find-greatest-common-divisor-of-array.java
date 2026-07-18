class Solution {
    public static int gcd(int n1, int n2) {
        if(n2 == 0) {
            return n1;
        }

        return gcd(n2, n1 % n2);
    }

    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int ele : nums) {
            max = Math.max(max, ele);
            min = Math.min(min, ele);
        }

        return gcd(min, max);
    }
}