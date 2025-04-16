class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegrees = new int[n];
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if (edges[i] != -1) {
                graph.get(i).add(edges[i]);
                ++indegrees[edges[i]];
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        boolean[] visit = new boolean[n];
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int dependentNode : graph.get(node)) {
                if (--indegrees[dependentNode] == 0) {
                    queue.add(dependentNode);
                }
            }

            visit[node] = true;
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                int cycleLength = calculateCycleLength(edges, visit, i);
                max = Math.max(max, cycleLength);
            }
        }

        return max;
    }

    private int calculateCycleLength(int[] edges, boolean[] visit, int node) {
        int length = 1;
        int dependentNode = edges[node];
        visit[node] = true;
        while (dependentNode != node) {
            visit[dependentNode] = true;
            dependentNode = edges[dependentNode];
            ++length;
        }

        return length;
    }
}