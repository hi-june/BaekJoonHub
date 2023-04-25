import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());    // test case의 개수

        for (int i = 0; i < t; i++) {   // test case의 개수만큼 반복
            StringTokenizer st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());   // 배추밭의 가로길이(열)
            int n = Integer.parseInt(st.nextToken());   // 배추밭의 세로 길이(행)
            int k = Integer.parseInt(st.nextToken());   // 배추의 개수

            int[][] graph = new int[n][m];  // 배추밭

            // 배추밭 초기화
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken()); // 열
                int col = Integer.parseInt(st.nextToken()); // 행

                graph[col][row] = 1;
            }

            int count = 0;  // 필요한 배추흰지렁이의 수

            // bfs 수행
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (dfs(graph, j, l, n, m)) {
                        count += 1;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static boolean dfs(int[][] graph, int col, int row, int n, int m) {
        if (col < 0 | col >= n | row < 0 | row >= m) return false;

        if (graph[col][row] == 1) {
            graph[col][row] = 0;
            dfs(graph, col + 1, row, n, m);
            dfs(graph, col - 1, row, n, m);
            dfs(graph, col, row + 1, n, m);
            dfs(graph, col, row - 1, n, m);
            return true;
        }

        return false;
    }
}