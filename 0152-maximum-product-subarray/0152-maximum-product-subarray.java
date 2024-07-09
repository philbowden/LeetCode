class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length; 

        double pre = 1, suff = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pre == 0) pre = 1;
            if (suff == 0) suff = 1;
            pre *= (double)nums[i];
            suff *= (double)nums[n - i - 1];
            ans = (int)Math.max(ans, Math.max(pre, suff));
        }
        return ans;
    }
}