class Solution {
    public int reverse(int n) {
        int ans = 0;
        while(n > 0) {

            int lastDigit = n % 10;
            ans = ans * 10 + lastDigit;
            n /= 10;
        }

        return ans;
    }
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {

            if(map.containsKey(nums[i])) {
                int lastIndex = map.get(nums[i]);
                minDistance = Math.min(minDistance, i - lastIndex);
            }

            int revNum = reverse(nums[i]);

            map.put(revNum, i);
        }

        return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
    }
}