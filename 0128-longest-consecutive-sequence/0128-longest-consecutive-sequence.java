class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) { 
            set.add(num);
        }

        for (int num : nums) {
            int current = num;
            int currentLen = 1;

            if (!set.contains(current - 1)) {
                while(set.contains(current + 1)) {
                    current++;
                    currentLen++;
                }
                max = Math.max(max, currentLen);
            }
        }
        return max;
    }
}