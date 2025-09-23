import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::valueOf)
            .toArray();

        int N = inputs[0];  // 노드의 수
        int M = inputs[1];  // 간선의 수
        int V = inputs[2];  // 탐색을 시작할 노드의 번호

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

            int f = inputs[0];
            int t = inputs[1];

            graph.get(f).add(t);
            graph.get(t).add(f);
        }

        graph.forEach(Collections::sort);

        boolean[] visitedDFS = new boolean[N + 1];
        dfs(graph, V, visitedDFS);
        bw.write("\n");

        boolean[] visitedBFS = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(V);
        visitedBFS[V] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            bw.write(node + " ");

            for (int adj : graph.get(node)) {
                if (!visitedBFS[adj]) {
                    queue.offer(adj);
                    visitedBFS[adj] = true;
                }
            }
        }

        bw.flush();

        br.close();
        bw.close();
    }

    public static void dfs(List<List<Integer>> graph, int V, boolean[] visited) throws IOException {
        visited[V] = true;
        bw.write(V + " ");

        for (int node : graph.get(V)) {
            if (!visited[node]) {
                dfs(graph, node, visited);
            }
        }
    }
}