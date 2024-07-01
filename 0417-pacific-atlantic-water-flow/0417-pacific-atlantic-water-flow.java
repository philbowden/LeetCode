class Solution {
    public static final int[][] DIRECTIONS = {{0,-1},{-1,0},{0,1},{1,0}};
    private int[][] heights;
    private int numRows;
    private int numCols;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights.length == 0) return res;

        this.heights = heights;
        numRows = heights.length;
        numCols = heights[0].length;

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        for (int i = 0; i < numRows; i++) {
            pacificQueue.offer(new int[] {i, 0});
            atlanticQueue.offer(new int[] {i, numCols-1});
        }
        for (int j = 0; j < numCols; j++) {
            pacificQueue.offer(new int[] {0,j});
            atlanticQueue.offer(new int[] {numRows-1, j});
        }

        boolean[][] pacReachable = bfs(pacificQueue);
        boolean[][] atlReachable = bfs(atlanticQueue);

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (pacReachable[i][j] && atlReachable[i][j]) {
                    res.add(Arrays.asList(i,j));
                }
            }
        }

        return res;
    }

    private boolean[][] bfs(Queue<int[]> queue) {
        boolean[][] reachable = new boolean[numRows][numCols];

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            reachable[cell[0]][cell[1]] = true;

            for (int[] dir : DIRECTIONS) {
                int currentRow = cell[0] + dir[0];
                int currentCol = cell[1] + dir[1];

                if (currentRow < 0 || currentRow >= numRows || currentCol < 0 || currentCol >= numCols) {
                    continue;
                }

                if (reachable[currentRow][currentCol]) {
                    continue;
                }

                if (heights[currentRow][currentCol] < heights[cell[0]][cell[1]]) {
                    continue;
                }

                queue.offer(new int[] {currentRow, currentCol});
            }
        }

        return reachable;
    }
}