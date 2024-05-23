class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] pair = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int partner = target - current;
            if (!map.containsKey(partner)) {
                map.put(current, i);
            } else {
                pair[0] = map.get(partner);
                pair[1] = i;
                return pair;
            }
        }
        return pair;
    }
}