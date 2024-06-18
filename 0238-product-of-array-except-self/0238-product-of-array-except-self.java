class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] forward = new int[n];
        forward[0] = 1;
        int[] backward = new int[n];
        backward[n-1] = 1;
        for (int i = 1; i < n; i++) {
            forward[i] = nums[i-1]*forward[i-1];
        }
        for (int i = n-2; i >= 0; i--) {
            backward[i] = nums[i+1] * backward[i+1];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = backward[i] * forward[i];
        }
        return nums;
    }
}