class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegrees = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            ++indegrees[pre[0]];
        }

        int completedCourses = 0;
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] ==0) que.add(i);
        }

        while(!que.isEmpty()) {
            int course = que.poll();
            for (int dependentCourse : graph.get(course)) {
                if (--indegrees[dependentCourse] == 0) {
                    que.add((dependentCourse));
                }
            }
            ++completedCourses;
        }

        return completedCourses == numCourses;
    }
}
/*



*/ 