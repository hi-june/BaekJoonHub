import java.util.*;

class Solution {
    private static class Node {
        public int col;
        public int row;
        
        private Node(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }
    
    /*
    [
    [1,0,1,1,1],
    [1,0,1,0,1],
    [1,0,1,1,1],
    [1,1,1,0,1],
    [0,0,0,0,1]
    ]
    */
    static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int solution(int[][] maps) {
        int maxCol = maps.length;
        int maxRow = maps[0].length;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            // 상하좌우 움직임
            for (int[] d : directions) {
                int newCol = node.col + d[0];
                int newRow = node.row + d[1];
                
                if (newCol >= maxCol || newCol < 0 || newRow >= maxRow || newRow < 0) {
                    continue;
                }
                
                if (maps[newCol][newRow] > 1 || maps[newCol][newRow] == 0) {
                    continue;
                }
                
                queue.offer(new Node(newCol, newRow));
                maps[newCol][newRow] = maps[node.col][node.row] + 1;
            }
        }
        
        return (maps[maxCol - 1][maxRow - 1] == 1) ? -1 : maps[maxCol - 1][maxRow - 1];
    }
}