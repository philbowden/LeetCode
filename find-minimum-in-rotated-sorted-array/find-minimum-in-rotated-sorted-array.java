class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            
            if (mid > 0 && nums[mid-1] > nums[mid]) return nums[mid];
            else if (nums[mid] > nums[right]) left = mid+1;
            else right = mid;
        }
        return nums[left];
    }
}