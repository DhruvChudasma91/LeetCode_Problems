class Solution {
    public int uniqueXorTriplets(int[] nums) {
        
        int n = nums.length;

        if(n == 1) return 1;

        boolean[] pairXor = new boolean[2048];
        boolean[] answer = new boolean[2048];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pairXor[nums[i] ^ nums[j]] = true;
            }
        }

        // XOR every pair XOR with every number
        for (int xor = 0; xor < 2048; xor++) {

            if (!pairXor[xor]) continue;

            for (int num : nums) {
                answer[xor ^ num] = true;
            }
        }

        // Count distinct XOR values
        int count = 0;

        for (boolean present : answer) {
            if (present) count++;
        }

        return count;
    }
}