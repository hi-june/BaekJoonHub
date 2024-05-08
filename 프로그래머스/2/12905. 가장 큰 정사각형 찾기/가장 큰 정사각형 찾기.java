class Solution {
    public int solution(int[][] board) {
        int size = 0;
        
        for (int col = 0; col < board.length; col++) {
            for (int row = 0; row < board[0].length; row++) {
                if (board[col][row] == 0) continue;
                if (col - 1 < 0 || row - 1 < 0) {
                    size = Math.max(size, 1);
                    continue;
                }
                
                board[col][row] = Math.min(Math.min(board[col - 1][row], board[col][row - 1]), board[col - 1][row - 1]) + 1;
                size = Math.max(size, board[col][row]);
            }
        }

        return size * size;
    }
}