class Solution {
        public int shipWithinDays(int[] weights, int days) {
        int left = weights[0];
        int right = 0;
        for (int weight : weights) {
            left = Math.max(weights[0], weight);
            right+=weight;
        }

        while(left < right) {
            int mid = left + (right - left) / 2;
            if (isPossible(weights, days, mid)) {
                right = mid;
            }
            else left = mid + 1;
        }
        return left;
    }
    private boolean isPossible(int[] weights, int days, int cap) {
        int currentDays = 1;
        int currentWeight = 0;
        for (int weight : weights) {
            if (weight > cap) {
                return false;
            }
            if (currentWeight + weight > cap) {
                currentDays++;
                currentWeight = weight;
            } else {
                currentWeight+=weight;
            }
        }
        return currentDays <= days;
    }
}