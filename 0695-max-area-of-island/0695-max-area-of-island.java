class Solution {
    int[][] grid;
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(i,j));
                }
            }
        }
        return max;
    }
    private int dfs(int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        int count = 1;
        count += dfs(i+1,j);
        count += dfs(i-1,j);
        count += dfs(i,j+1);
        count += dfs(i,j-1);
        return count;
    }
}