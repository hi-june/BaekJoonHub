import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static int[] nums;
    private static int[] picked;
    // private static boolean[] visited;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        int[] inputs = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int N = inputs[0];
        int M = inputs[1];

        nums = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        Arrays.sort(nums);
        // visited = new boolean[N];
        picked = new int[M];

//        for (int i = 0; i < N; i++) {
//            nums[i] = i + 1;
//        }

        dfs(0);

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void dfs(int depth) {
        if (depth == picked.length) {
            sb.append(
                Arrays.stream(picked)
                    .mapToObj(Integer::toString)
                    .collect(Collectors.joining(" "))
            ).append("\n");
            return;
        }

        int before = 0;
        for (int i = 0; i < nums.length; i++) {
            // if (visited[i]) continue;
            if (before == nums[i]) continue;

            // visited[i] = true;
            picked[depth] = nums[i];
            before = nums[i];
            dfs(depth + 1);
            // visited[i] = false;
        }
    }
}