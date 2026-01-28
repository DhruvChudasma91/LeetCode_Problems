class NumArray {
    private int[] arr;

    public NumArray(int[] nums) {
        arr = new int[nums.length + 1];
        arr[0] = 0;
        for (int i = 0; i < nums.length; i++)
            arr[i + 1] = nums[i] + arr[i];
    }

    public int sumRange(int left, int right) {
        return arr[right + 1] - arr[left];
    }
}