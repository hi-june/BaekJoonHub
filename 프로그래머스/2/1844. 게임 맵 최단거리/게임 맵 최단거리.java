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

    public int solution(int[][] maps) {
        int maxCol = maps.length;
        int maxRow = maps[0].length;
        boolean[][] visited = new boolean[maxCol][maxRow];

        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < maxRow; j++) {
                if (maps[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int step = maps[node.col][node.row];
            
            if (node.col == maxCol - 1 && node.row == maxRow - 1) {
                return step;
            }

            for (int[] direction : directions) {
                int newCol = node.col + direction[0];
                int newRow = node.row + direction[1];

                if (newCol < 0 || newCol >= maxCol || newRow < 0 || newRow >= maxRow) continue;

                if (visited[newCol][newRow]) continue;

                maps[newCol][newRow] = step + 1;
                queue.offer(new Node(newCol, newRow));
                visited[newCol][newRow] = true;
            }
        }

        return -1;
    }
}