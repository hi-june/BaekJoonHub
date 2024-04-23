class Solution {
    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String color = board[h][w];
        
        for (int[] d : directions) {
            int col = h + d[0];
            int row = w + d[1];
            
            if (col < 0 || col >= board.length || row < 0 || row >= board[0].length) continue;
            
            if (board[col][row].equals(color)) answer++;
        }
        
        return answer;
    }
}