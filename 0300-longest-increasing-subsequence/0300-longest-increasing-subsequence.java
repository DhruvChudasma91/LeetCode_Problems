class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);

        for(int i = 1; i < n; i++) {

            int last = temp.get(temp.size() - 1);

            if(last < nums[i]) {
                temp.add(nums[i]);
            } else {

                int s = 0;
                int e = temp.size() - 1;

                while(s < e) {

                    int mid = s + (e - s) / 2;
                    if(temp.get(mid) < nums[i]) {
                        s = mid + 1;
                    } else {
                        e = mid;
                    }
                }

                temp.set(s, nums[i]);
            }
        }

        return temp.size();

    }
}