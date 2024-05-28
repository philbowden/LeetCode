class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = weights[0];
        int right = 0;
        for (int weight : weights) {
            right+=weight;
            left = Math.max(left, weight);
        }
   
        while(left < right) {
            int mid = left + (right - left) / 2;
            boolean isValid = checkCapacity(weights, days, mid);
            if (isValid) right = mid;
            else left = mid+1;
        }
        return left;
    }
    private boolean checkCapacity(int[] weights,int days,int cap) {
        int numDays = 0;
        int runningTotal = 0;
        for (int weight : weights) {
            runningTotal += weight;
            if (runningTotal > cap) {
                numDays++;
                runningTotal = weight;
            }
        }
        numDays++;
        return numDays <= days;
    }
    
}