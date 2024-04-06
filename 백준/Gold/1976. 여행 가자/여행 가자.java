import java.io.*;
import java.util.*;

public class Main {
    private static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());    // 전체 도시 수
        int M = Integer.parseInt(br.readLine());    // 여행 경로

        map = new int[N];
        for (int i = 0; i < N; i++) {
            map[i] = i;
        }

        for (int i = 0; i < N; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                if (inputs[j] == 1) {
                    merge(i, j);
                }
            }
        }

        int[] plan = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        boolean flag = true;
        int root = findRoot(map[plan[0] - 1]);
        for (int i = 1; i < plan.length; i++) {
            int compRoot = findRoot(map[plan[i] - 1]);

            if (root != compRoot) {
                flag = false;
                break;
            }
        }

        String answer = flag ? "YES" : "NO";

        bw.write(answer);
        bw.flush();

        br.close();
        bw.close();
    }

    private static void merge(int node1, int node2) {
        int root1 = findRoot(node1);
        int root2 = findRoot(node2);

        if (root1 < root2) {
            map[root2] = root1;
        } else if (root1 > root2) {
            map[root1] = root2;
        }
    }

    private static int findRoot(int node) {
        if (map[node] != node) {    // 만약 루트 노드가 아니라면
            map[node] = findRoot(map[node]);  // 루트를 찾을 때까지 재귀 호출
        }

        return map[node];
    }
}