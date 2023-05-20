import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int col;
        int row;
        int cost;

        public Node(int col, int row, int cost) {
            this.col = col;
            this.row = row;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return cost - n.cost;
        }
    }

    static int[][] cave;    // 동굴
    static int[][] map;     // 최단 거리 기록용
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = 0;

        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) break;

            cave = new int[N][N];
            map = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                int[] colArray = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                cave[i] = colArray;
                Arrays.fill(map[i], INF);
            }

            PriorityQueue<Node> queue = new PriorityQueue<>();

            queue.offer(new Node(0, 0, cave[0][0]));
            visited[0][0] = true;

            while (!queue.isEmpty()) {
                Node node = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int mX = node.col + dx[i];
                    int mY = node.row + dy[i];

                    if (mX < 0 || mX >= N || mY < 0 || mY >= N) continue;

                    if (!visited[mX][mY] && map[mX][mY] > (cave[mX][mY] + node.cost)) {
                        map[mX][mY] = cave[mX][mY] + node.cost;
                        visited[mX][mY] = true;
                        queue.offer(new Node(mX, mY, map[mX][mY]));
                    }
                }
            }

            bw.write(String.format("Problem %d: %d\n", ++count, map[N - 1][N - 1]));
        }

        bw.flush();
        bw.close();
    }
}