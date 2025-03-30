class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegrees = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
           graph.get(pre[1]).add(pre[0]);
           indegrees[pre[0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
            }
        }
        int completedCourses = 0;
        while(!q.isEmpty()) {
            int course = q.poll();
            List<Integer> dependentCourses = graph.get(course);
            for (int dependent : dependentCourses) {
                --indegrees[dependent];
                if (indegrees[dependent] == 0) q.add(dependent);
            }
            completedCourses++;
        }
        return completedCourses == numCourses;
    }
}