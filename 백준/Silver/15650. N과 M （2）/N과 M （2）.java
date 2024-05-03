import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] inputs = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int N = inputs[0];
        int M = inputs[1];

        arr = new int[M];

        dfs(1, 0, N, M);

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void dfs(int at, int depth, int N, int M) {
        if (depth == M) {
            String line = Arrays.stream(arr)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" "));

            sb.append(line).append("\n");
            return;
        }

        for (int i = at; i <= N; i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1, N, M);
        }
    }
}