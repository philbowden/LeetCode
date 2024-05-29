class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= target) return i;
            if (i == n-1) return i+1;
        }
        return 0;
    }
}