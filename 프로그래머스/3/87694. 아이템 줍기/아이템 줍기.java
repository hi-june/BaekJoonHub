import java.util.*;

class Solution {
    private int[][] map = new int[101][101];
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    private class Node {
        int col;
        int row;
        
        private Node(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] rect : rectangle) {
            int lx = rect[0];
            int ly = rect[1];
            
            int rx = rect[2];
            int ry = rect[3];
            
            draw(lx * 2, ly * 2, rx * 2, ry * 2);
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(characterY * 2, characterX * 2));
        map[characterY * 2][characterX * 2] = 0;
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            if (node.col == itemY * 2 && node.row == itemX * 2) {
                return map[node.col][node.row] / 2;
            }
            
            for (int[] d : directions) {
                int nCol = node.col + d[0];
                int nRow = node.row + d[1];
                
                if (nCol < 0 || nCol >= 101 || nRow < 0 || nRow >= 101) continue;
                if (map[nCol][nRow] != 1) continue;
                
                map[nCol][nRow] = map[node.col][node.row] + 1;
                queue.offer(new Node(nCol, nRow));
            }
        }
        
        return -1;
    }
    
    private void draw(int lx, int ly, int rx, int ry) {
        // 테두리는 1, 내부는 -1
        // 0일 때만 테두리 그리기
        
        for (int y = ly; y <= ry; y++) {
            for (int x = lx; x <= rx; x++) {
                if (x == lx || x == rx || y == ly || y == ry) { // 테두리인 경우
                    if (map[y][x] == 0) map[y][x] = 1;
                } else {    // 내부인 경우
                    map[y][x] = -1;
                }
            }
        }
    }
}