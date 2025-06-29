class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i = 0, j = 0;
        double maxAverage = Integer.MIN_VALUE, sum = 0.0;
        int n = nums.length;

        while(j < n) {
            sum+=nums[j];
            if (k == j - i + 1) {
                maxAverage = Math.max(maxAverage, sum / k);
                sum = sum - nums[i++];
            }
            ++j;
        }
        return maxAverage;
    }
}