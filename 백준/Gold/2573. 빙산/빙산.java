import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] map;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static class Node {
        int col;
        int row;

        private Node(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int N = inputs[0];
        int M = inputs[1];

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        int year = 0;
        while (true) {
            // 0. check divide
            int count = 0;
            boolean[][] visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) continue;
                    if (visited[i][j]) continue;

                    Queue<Node> queue = new LinkedList<>();
                    queue.offer(new Node(i, j));
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        Node node = queue.poll();

                        for (int[] d : directions) {
                            int dCol = node.col + d[0];
                            int dRow = node.row + d[1];

                            if (dCol >= N || dCol < 0 || dRow >= M || dRow < 0) continue;
                            if (map[dCol][dRow] == 0 || visited[dCol][dRow]) continue;

                            queue.offer(new Node(dCol, dRow));
                            visited[dCol][dRow] = true;
                        }
                    }

                    count++;
                }
            }

            if (count > 1) {
                bw.write(year + "");
                break;
            }

            if (count == 0) {
                bw.write("0");
                break;
            }

            // 1. create adj map
            int[][] adjMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) continue;

                    int iceCount = 0;
                    for (int[] d : directions) {
                        int dCol = i + d[0];
                        int dRow = j + d[1];

                        if (dCol >= N || dCol < 0 || dRow >= M || dRow < 0) continue;

                        if (map[dCol][dRow] == 0) iceCount++;
                    }

                    adjMap[i][j] = iceCount;
                }
            }

            // 2. melting ice
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) continue;

                    map[i][j] = Math.max(map[i][j] - adjMap[i][j], 0);
                }
            }

            year++;
        }

        bw.flush();

        br.close();
        bw.close();
    }
}


