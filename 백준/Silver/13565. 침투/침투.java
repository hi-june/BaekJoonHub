import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken()); // 행
        int row = Integer.parseInt(st.nextToken()); // 열

        int[][] graph = new int[col][row];  // map

        // graph initialize
        for (int i = 0; i < col; i++) {
            int[] rowArray = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            graph[i] = rowArray;
        }

        // last column을 저장해둔다.
        int[] lastCol = graph[col - 1].clone();

        // bfs 수행
        for (int i = 0; i < row; i++) {
            if (graph[0][i] == 0) {
                bfs(graph, 0, i, col, row);
            }
        }

        String answer = "NO";
        for (int i = 0; i < row; i++) {
            if (graph[col - 1][i] != lastCol[i]) {  // 마지막 column의 상태가 처음과 달라졌다면 침투한 것임
                answer = "YES";
                break;
            }
        }

        System.out.println(answer);
    }

    public static void bfs(int[][] graph, int col, int row, int colMax, int rowMax) {
        // 범위를 벗어나면 종료
        if (col < 0 | col >= colMax | row < 0 | row >= rowMax) return;

        // 0: 흰색, 1: 검은색
        if (graph[col][row] == 0) { // if block is white
            graph[col][row] = 1;
            bfs(graph, col - 1, row, colMax, rowMax);   // 상
            bfs(graph, col + 1, row, colMax, rowMax);   // 하
            bfs(graph, col, row + 1, colMax, rowMax);   // 우
            bfs(graph, col, row - 1, colMax, rowMax);   // 좌
        }
    }
}