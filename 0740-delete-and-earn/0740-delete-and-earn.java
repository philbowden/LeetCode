class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> uniqueNums = new ArrayList<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
                uniqueNums.add(num);
            }
            else {
                map.put(num, map.get(num) + 1);
            }
        }
        Collections.sort(uniqueNums);
        int size = uniqueNums.size();
        int[] dp = new int[size];
        int first = uniqueNums.get(0);
        dp[0] = first * map.get(first);
        for (int i = 1; i < uniqueNums.size(); i++) {
            int cur = uniqueNums.get(i);
            int prev = uniqueNums.get(i - 1);
            if (prev + 1 == cur) {
                if (i >= 2) {
                    dp[i] = Math.max(dp[i - 1], cur * map.get(cur) + dp[i - 2]);
                }
                else {
                    dp[i] = Math.max(dp[i - 1], cur * map.get(cur));
                }
            }
            else {
                dp[i] = cur * map.get(cur) + dp[i - 1];
            }
        }
        return dp[size - 1];
    }
}