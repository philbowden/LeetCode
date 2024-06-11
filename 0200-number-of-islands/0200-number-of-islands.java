class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    sinkIslands(grid, i, j);
                }
            }
        }
        return count;
    }

    private void sinkIslands(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        sinkIslands(grid, i+1, j);
        sinkIslands(grid, i-1, j);
        sinkIslands(grid, i, j-1);
        sinkIslands(grid, i, j+1);
    
    }
}