class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverseArray(nums,0, nums.length-1);
        reverseArray(nums, 0, k-1);
        reverseArray(nums, k, nums.length-1);
    }
    private void reverseArray(int[] nums, int left, int right) {
        while(left < right) {
            swap(nums,left,right);
            left++;
            right--;
        }
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}