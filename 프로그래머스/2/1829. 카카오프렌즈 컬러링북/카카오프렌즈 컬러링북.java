import java.util.*;

class Solution {
    private static class Node {
        int col, row;
        
        private Node(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }
    
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int[] solution(int m, int n, int[][] picture) {
        int count = 0;
        int maxSize = 0;
        
        for (int col = 0; col < m; col++) {
            for (int row = 0; row < n; row++) {
                if (picture[col][row] != 0) {
                    maxSize = Math.max(maxSize, visitAllAndGetSize(col, row, picture));
                    count++;
                }
            }
        }
        
        return new int[]{count, maxSize};
    }
    
    private static int visitAllAndGetSize(int col, int row, int[][] picture) {
        int size = 0;
        int targetNum = picture[col][row];
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(col, row));
        picture[col][row] = 0;
        size++;
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            for (int[] d : directions) {
                int nCol = node.col + d[0];
                int nRow = node.row + d[1];

                if (nCol < 0 || nCol >= picture.length || nRow < 0 || nRow >= picture[0].length) continue;
                if (picture[nCol][nRow] != targetNum || picture[nCol][nRow] == 0) continue;

                queue.offer(new Node(nCol, nRow));
                picture[nCol][nRow] = 0;
                size++;
            }
        }
        
        return size;
    }
}