import java.util.*;

class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    private class Node {
        int col;
        int row;
        
        private Node(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }
    
    public int solution(int[][] maps) {
        int maxCol = maps.length;
        int maxRow = maps[0].length;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            for (int[] d : directions) {
                int nCol = node.col + d[0];
                int nRow = node.row + d[1];
                
                if (nCol < 0 || nCol >= maps.length || nRow < 0 || nRow >= maps[0].length) continue;
                if (maps[nCol][nRow] == 0 || maps[nCol][nRow] != 1) continue;
                
                maps[nCol][nRow] = maps[node.col][node.row] + 1;
                queue.offer(new Node(nCol, nRow));
            }
        }
        
        return (maps[maxCol - 1][maxRow - 1] == 1) ? -1 : maps[maxCol - 1][maxRow - 1];
    }
}