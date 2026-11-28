class Solution {
    public int[] rearrangeArray(int[] nums) {

        int n = nums.length;

        Queue<Integer> positives = new LinkedList<>();
        Queue<Integer> negatives = new LinkedList<>();

        for(int num : nums) {

            if(num > 0) {
                positives.add(num);
            } else {
                negatives.add(num);
            }
        }

        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {

            if(i % 2 == 0) {
                ans[i] = positives.remove();
            } else {
                ans[i] = negatives.remove();
            }
        }

        return ans;
        
    }
}