class Solution {
    public int missingNumber(int[] nums) {
        int totalSum = nums.length;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += i;
            currentSum += nums[i];
        }
        return totalSum - currentSum;
    }
}