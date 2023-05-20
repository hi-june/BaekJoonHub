import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        int[][] graph = new int[N][];
        
        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }
        
        // Floyd Warshall
        // 거쳐가는 정점이 k(모든 노드에 대해)일 때, i에서 j로 가는 경로가 존재하는가
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }
        
        for (int[] row : graph) {
            String rowString = Arrays.stream(row)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
            bw.write(rowString + "\n");
        }
        bw.flush();
        bw.close();
    }
}