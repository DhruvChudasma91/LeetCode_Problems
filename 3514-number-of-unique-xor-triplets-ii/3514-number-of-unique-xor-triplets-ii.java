class Solution {
    public int uniqueXorTriplets(int[] nums) {
        
        int n = nums.length;

        if(n <= 1) return n;

        HashSet<Integer> xors = new HashSet<>();

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {

                int xor = nums[i] ^ nums[j];
                xors.add(xor);
            }
        }

        HashSet<Integer> set = new HashSet<>();

        for(int xor : xors) {
            for(int i : nums) {
                set.add(xor ^ i);
            }
        }

        return set.size();
    }
}