class Solution {

    public void reverse(int s, int e, int[] nums) {
        while(s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }

    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        k = k % n;

        reverse(0, n-1, nums);
        reverse(0, k-1, nums);
        reverse(k, n-1, nums);
        
    }
}