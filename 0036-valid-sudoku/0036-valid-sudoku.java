class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char current = board[i][j];
                if (current != '.') {
                   if (!set.add("row " + i + " -> " + current)) return false;
                   if (!set.add("col " + j + " -> " + current)) return false;
                   if (!set.add("box [" + i/3 + ", " + j/3 + "] -> " +  current)) return false;
                }
            }
        }
        return true;
    }
}