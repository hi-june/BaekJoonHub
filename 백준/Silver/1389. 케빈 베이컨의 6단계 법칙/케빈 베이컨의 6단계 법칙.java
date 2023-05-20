import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());   // 유저의 수
        int M = Integer.parseInt(st.nextToken());   // 친구 관계의 수
        
        int INF = N;  // 최대 거리
        int[][] graph = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            Arrays.fill(graph[i], INF);
        }
        
        // graph initialize
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int u1 = Integer.parseInt(st.nextToken());
            int u2 = Integer.parseInt(st.nextToken());
            
            graph[u1 - 1][u2 - 1] = 1;
            graph[u2 - 1][u1 - 1] = 1;
        }
        
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        
        List<Integer> kevinList = new ArrayList<>();
        
        for (int[] g : graph) {
            int total = Arrays.stream(g).sum();
            kevinList.add(total);
        }
        
        System.out.println(kevinList.indexOf(Collections.min(kevinList)) + 1);
    }
}