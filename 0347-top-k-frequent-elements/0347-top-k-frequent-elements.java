class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+ 1);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            q.add(new int[]{entry.getKey(), entry.getValue()});
            if (q.size() > k) q.poll();
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = 0; i < k; i++) {
            int[] cur = q.poll();
            res[index++] = cur[0];
        }
        return res;
    }
}