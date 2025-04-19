class Solution {
    public int longestCycle(int[] edges) {
        //make graph (hashmap)
        int n = edges.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegrees = new int[n];

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        //add dependents
        for (int i = 0; i < n; i++) {
            if (edges[i] != -1) {
                graph.get(i).add(edges[i]);
                indegrees[edges[i]]++;
            }
        }
        //loop over edges and find nodes without dependents
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
                visited[i] = true;
            }
        }
        //process nodes track with boolean array
        int max = -1;
        while(!q.isEmpty()) {
            int node = q.poll();
            for (int dependent : graph.get(node)) {
                if (--indegrees[dependent] == 0) {
                    q.add(dependent);
                    visited[dependent] = true;
                }
            }
        }
        //check for cycles and length
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                max = Math.max(max, getLength(visited, edges, i));
            }
        }
        return max;
    }
    private int getLength(boolean[] visited, int[] edges, int node) {
        int count = 1;
        int current = edges[node];
        while(current != node) {
            count++;
            current = edges[current];
            visited[current] = true;
        }
        return count;
    }
}