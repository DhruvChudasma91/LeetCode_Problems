class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {

            int ind = Math.abs(nums[i]);
            if(nums[ind - 1] < 0) {
                ans.add(ind);
            }

            nums[ind - 1] *= -1;
        }

        return ans;
    }
}