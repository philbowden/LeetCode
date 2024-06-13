class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<String, Set<Character>> map = new HashMap<>();
        String row = "";
        String col = "";
        String square = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char current = board[i][j];
                if (current != '.') {
                    row = "row " + i;
                    col = "col " + j;
                    square = "square [" + i/3 +", " + j/3 +"]";
                    if (!map.containsKey(row)) map.put(row, new HashSet<>());
                    if(!map.get(row).add(current)) return false;

                    if (!map.containsKey(col)) map.put(col, new HashSet<>());
                    if (!map.get(col).add(current)) return false;

                    if (!map.containsKey(square)) map.put(square, new HashSet<>());
                    if (!map.get(square).add(current)) return false;
            }
        }
      }
        return true;
    }
}