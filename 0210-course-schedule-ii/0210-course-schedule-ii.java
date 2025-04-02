class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegrees = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            indegrees[pre[0]]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) que.add(i);
        }
        List<Integer> completed = new ArrayList<>();
        while(!que.isEmpty()) {
            int course = que.poll();
            List<Integer> dependents = graph.get(course);
            for (int dependent : dependents) {
                indegrees[dependent]--;
                if (indegrees[dependent] == 0) que.add(dependent);
            }
            completed.add(course);
        }
        if (completed.size() == numCourses) {
            int[] result = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                result[i] = completed.get(i);
            }
            return result;
        }
        return new int[0];
    }
}