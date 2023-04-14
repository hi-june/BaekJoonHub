import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n, m, v 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        // graph 초기화
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        // 순서 유지를 위한 정렬
        graph.forEach(Collections::sort);

        // DFS
        boolean[] visitedDFS = new boolean[n + 1];
        dfs(graph, v, visitedDFS);

        System.out.println();

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visitedBFS = new boolean[n + 1];

        queue.offer(v);
        visitedBFS[v] = true;

        while (!queue.isEmpty()) {
            int visitedNode = queue.poll();
            System.out.print(visitedNode + " ");

            for (int node : graph.get(visitedNode)) {
                if (!visitedBFS[node]) {
                    queue.offer(node);
                    visitedBFS[node] = true;
                }
            }
        }
    }

    public static void dfs(List<List<Integer>> graph, int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int node : graph.get(v)) {
            if (!visited[node]) {
                dfs(graph, node, visited);
            }
        }
    }
}