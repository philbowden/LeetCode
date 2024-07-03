class Solution {
    char[][] board;
    int numRows;
    int numCols;
    public void solve(char[][] board) {
        this.board = board;
        numRows = board.length;
        numCols = board[0].length;
   
        for (int i = 0; i < numRows; i++) {
           if (board[i][0] == 'O') traverse(i,0);
           if (board[i][numCols-1] == 'O') traverse(i, numCols-1);
        }
        for (int j = 0; j < numCols; j++) {
            if (board[0][j] == 'O') traverse(0,j);
            if (board[numRows-1][j] == 'O') traverse(numRows-1,j);
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'Z') board[i][j] = 'O';
            }
        }

    }
    private void traverse(int i, int j) {
        if (i < 0 || i >= numRows || j < 0 || j >= numCols || board[i][j] != 'O') {
            return;
        }
        
        board[i][j] = 'Z';
        
        if (i < numRows-1 && board[i+1][j] == 'O') traverse(i+1,j);
        
        if (i > 0 && board[i-1][j] == 'O') traverse(i-1,j);
        
        if (j < numCols-1 && board[i][j+1] == 'O') traverse(i,j+1);
        
        if (j > 0 && board[i][j-1] == 'O') traverse(i,j-1);
        
    }
}