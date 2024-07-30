class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int[] element = {entry.getKey(), entry.getValue()};
            q.add(element);
            if (q.size() > k) q.poll();
        }
        for (int i = 0; i < k; i++) {
            int[] pair = q.poll();
            res[i] = pair[0];
        }
        return res;
    }
}