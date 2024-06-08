class Solution {
    /*
     m
     0 1 2 3 4 5 6
    [0,1,2,4,5,6,7]    
     l
       r
    */ 
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;

        while(left < right) {
            int mid = left + (right - left) / 2;
                 //    4 + (5-4)/2
            if (nums[mid] > nums[right]) left = mid+1;
            else right = mid;
        }
        return nums[left];
    }
}