class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            q.add(stone);
        }
        while(q.size() > 1) {
            int s1 = q.poll();
            int s2 = q.poll();
            int diff = s1 - s2;
            if (diff > 0) q.add(diff);
        }
        return q.size() == 1 ? q.peek() : 0;
    }
}