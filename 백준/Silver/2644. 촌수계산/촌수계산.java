import java.io.*;
import java.util.*;

public class Main {
    public static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int target1 = Integer.parseInt(st.nextToken());
        int target2 = Integer.parseInt(st.nextToken());

        int relation = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < relation; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        boolean[] visited = new boolean[n + 1];

        dfs(graph, visited, target1, target2, 0);
        System.out.println(answer);
    }

    public static void dfs(List<List<Integer>> graph, boolean[] visited, int target1, int target2, int depth) {
        visited[target1] = true;

        for (int node : graph.get(target1)) {
            if (!visited[node]) {
                if (node == target2) {
                    answer = depth + 1;
                    return;
                }
                dfs(graph, visited, node, target2, depth + 1);
            }
        }
    }
}