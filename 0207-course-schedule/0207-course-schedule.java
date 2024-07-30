class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //store courses and prereqs into map
        for (int[] node : prerequisites) {
            if (!map.containsKey(node[0])) map.put(node[0], new ArrayList<>());
            List<Integer> prereqs = map.get(node[0]);
            prereqs.add(node[1]);
        }
        //loop through each class and make sure it doesn't have a cycle
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false;
        }
        return true;
    }
    private boolean dfs(int course) {
        //if the set already has the course then there's a cycle
        if (set.contains(course)) return false;

        //if the map contains the course but value is empty then it doesn't have dependencies
        if (map.containsKey(course) && map.get(course).isEmpty()) return true;

        set.add(course);
        List<Integer> courses = new ArrayList<>();
        if (map.containsKey(course)) courses = map.get(course);
        for (int c : courses) {
            if (!dfs(c)) return false;
            }
            //if course doesn't have cycle then remove it from set and give it an empty list in map
            set.remove(course);
            map.put(course, new ArrayList<>());
            return true;
    }
}