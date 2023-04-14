import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    // 컴퓨터의 수
        int connection = Integer.parseInt(br.readLine());   // 연결(간선)의 수

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < connection; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        boolean[] visited = new boolean[n+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int visitedNode = queue.poll();
            count += 1;
            for (int node : graph.get(visitedNode)) {
                if (!visited[node]) {
                    queue.offer(node);
                    visited[node] = true;
                }
            }
        }

        System.out.println(count - 1);
    }
}