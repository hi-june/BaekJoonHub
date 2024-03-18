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

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int step = maps[node.col][node.row];

            if (node.row + 1 < maxRow && !visited[node.col][node.row + 1]) {    // 우
                maps[node.col][node.row + 1] = step + 1;
                queue.offer(new Node(node.col, node.row + 1));
                visited[node.col][node.row + 1] = true;
            }
            if (node.row - 1 >= 0 && !visited[node.col][node.row - 1]) { // 좌
                maps[node.col][node.row - 1] = step + 1;
                queue.offer(new Node(node.col, node.row - 1));
                visited[node.col][node.row - 1] = true;
            }
            if (node.col - 1 >= 0 && !visited[node.col - 1][node.row]) {    // 상
                maps[node.col - 1][node.row] = step + 1;
                queue.offer(new Node(node.col - 1, node.row));
                visited[node.col - 1][node.row] = true;
            }
            if (node.col + 1 < maxCol && !visited[node.col + 1][node.row]) {    // 하
                maps[node.col + 1][node.row] = step + 1;
                queue.offer(new Node(node.col + 1, node.row));
                visited[node.col + 1][node.row] = true;
            }
        }

        return (maps[maxCol - 1][maxRow - 1] == 1) ? -1 : maps[maxCol - 1][maxRow - 1];
    }
}