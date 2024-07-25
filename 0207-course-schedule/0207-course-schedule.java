class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int[] node : prerequisites) {
            if (!map.containsKey(node[0])) map.put(node[0], new ArrayList<>());
            List<Integer> list = map.get(node[0]);
            list.add(node[1]);
            map.put(node[0], list);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false;
        }
        return true;
    }
    private boolean dfs(int course) {
        if (set.contains(course)) {
            return false;
        }
        if (map.containsKey(course) && map.get(course).isEmpty()) {
            return true;
        }

        set.add(course);
        List<Integer> prereqs = new ArrayList<>();
        if (map.containsKey(course)) {
            prereqs = map.get(course);
        }
        for (int c : prereqs) {
            if (!dfs(c)) return false;
        }
        set.remove(course);
        map.put(course, new ArrayList<>());
        return true;
    }
}