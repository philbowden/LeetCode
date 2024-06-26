class Solution {
    public int mySqrt(int x) {
        long left = 0, right = x;
        
        while(left < right) {
            long mid = left + (right - left + 1) / 2;
            long cur = mid * mid;
            if (cur == x) return (int)mid;
            else if (cur < x) left = mid;
            else right = mid-1;
        }
        return (int)left;
    }
}