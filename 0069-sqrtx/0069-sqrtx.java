class Solution {
    public int mySqrt(int x) {
        long left = 0, right = x / 2 + 1;

        while(left < right) {
            long mid = left + (right - left) / 2 + 1;
            long current = mid*mid;
            if (current == x) return (int)mid;
            else if (current < x) left = mid;
            else right = mid - 1;
        }
        return (int)left;
    }
}