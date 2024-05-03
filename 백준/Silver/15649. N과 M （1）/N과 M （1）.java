import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static boolean[] visited;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] inputs = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int N = inputs[0];
        int M = inputs[1];

        visited = new boolean[N];
        arr = new int[M];

        dfs(N, M, 0);

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void dfs(int N, int M, int depth) {
        if (depth == M) {
            String line = Arrays.stream(arr)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" "));

            sb.append(line).append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            int num = i + 1;

            visited[i] = true;
            arr[depth] = num;
            dfs(N, M, depth + 1);
            visited[i] = false;
        }
    }
}