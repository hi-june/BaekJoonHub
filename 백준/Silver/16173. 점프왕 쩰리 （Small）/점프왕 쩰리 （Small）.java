import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        public int col;
        public int row;

        private Node(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }

    public static void main(String[] args) throws IOException {
        // Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] maps = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            maps[i] = line;
        }

        boolean[][] visited = new boolean[n][n];

        int[][] directions = new int[2][2];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.col == n - 1 && node.row == n - 1) {
                bw.write("HaruHaru");
                bw.flush();

                bw.close();
                br.close();

                return;
            }

            int step = maps[node.col][node.row];
            directions[0] = new int[]{step, 0};
            directions[1] = new int[]{0, step};

            for (int[] direction : directions) {
                int newCol = node.col + direction[0];
                int newRow = node.row + direction[1];

                if (newCol >= n || newRow >= n || visited[newCol][newRow]) continue;

                queue.offer(new Node(newCol, newRow));
                visited[newCol][newRow] = true;
            }
        }

        bw.write("Hing");
        bw.flush();

        br.close();
        bw.close();
    }
}