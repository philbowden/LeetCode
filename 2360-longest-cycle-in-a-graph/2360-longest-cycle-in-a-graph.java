public class Solution {
    public static void main(String[] args) {
        int[] edges = {3,3,4,2,3};
        System.out.println(new Solution().longestCycle(edges));
    }

    public int longestCycle(int[] edges) {
        int n = edges.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegrees = new int[n];

        //add nodes to graph
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        //add edges to graph
        for (int i = 0; i < n; i++) {
            if (edges[i] != -1) {
                graph.get(i).add(edges[i]);
                indegrees[edges[i]]++;
            }
        }

        //add zero indegree nodes to queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
            }
        }

        //traverse the graph to find cycle
        boolean[] visited = new boolean[n];
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int dependentNode : graph.get(node)) {
                if (--indegrees[dependentNode] == 0) {
                    q.add(dependentNode);
                }
            }
            visited[node] = true;
        }
        //loop over visited to get max
        int max = -1;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                max = Math.max(max, calculateCycleLength(visited, edges, i));
            }
        }
        return max;
    }

    private int calculateCycleLength(boolean[] visited, int[] edges, int node) {
        int current = edges[node];
        int count = 1;
        while (current != node) {
            visited[current] = true;
            current = edges[current];
            count++;
        }
        return count;
    }

}