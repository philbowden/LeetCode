class Solution {
        public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<int[]> pairs = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            pairs.add(new int[] {pair.getKey(), pair.getValue()});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int[] pair : pairs) {
            pq.add(pair);
            if (pq.size() > k) pq.poll();
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int[] pair = pq.poll();
            res[i] = pair[0];
        }
        return res;
    }
}