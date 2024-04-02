import java.io.*;
import java.util.*;

public class Main {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};  // col, row
    private static int[][] map;
    private static int N;

    private static class Node {
        int col;
        int row;

        private Node(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }

    public static void main(String[] args) throws IOException {
        // Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        // map 초기화
        for (int i = 0; i < N; i++) {
            int[] cols = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

            map[i] = cols;
        }

        int count = 0;
        List<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < N; i++) {   // col
            for (int j = 0; j < N; j++) {   // row
                if (map[i][j] != 0) {
                    int size = visitAll(i, j);
                    sizes.add(size);
                    count++;
                }
            }
        }
        Collections.sort(sizes);

        bw.write(count + "\n");
        for (int s : sizes) {
            bw.write(s + "\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }

    private static int visitAll(int col, int row) {
        int size = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(col, row));
        map[col][row] = 0;
        size++;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int[] direction : directions) {
                int newCol = node.col + direction[0];
                int newRow = node.row + direction[1];

                if (newCol >= N || newCol < 0 || newRow >= N || newRow < 0) continue;

                if (map[newCol][newRow] == 0) continue;

                queue.offer(new Node(newCol, newRow));
                map[newCol][newRow] = 0;
                size++;
            }
        }

        return size;
    }
}