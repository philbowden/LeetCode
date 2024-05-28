class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i-1]);
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }
}