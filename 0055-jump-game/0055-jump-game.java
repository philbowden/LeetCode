class Solution {
    public boolean canJump(int[] nums) {
        int destination = nums.length-1;
        for (int i = destination-1; i >= 0; i--) {
            if (i + nums[i] >= destination) destination = i;
            if (destination == 0) return true;
        }
        return destination <= 0;
    }
    
}