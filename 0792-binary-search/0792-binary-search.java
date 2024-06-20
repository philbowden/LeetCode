class Solution {

    public int search(int[] nums, int target) {
        int left = 0, n = nums.length, right = n-1;
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid-1;
            else left = mid+1;
        }
        
        return nums[left] == target ? left : -1;
    }
}