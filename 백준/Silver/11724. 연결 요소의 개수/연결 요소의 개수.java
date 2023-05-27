import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];
        visited[0] = true;

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        Queue<Integer> queue = new LinkedList<>();

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                queue.offer(i);
                visited[i] = true;

                while (!queue.isEmpty()) {
                    int node = queue.poll();

                    for (int n : graph.get(node)) {
                        if (!visited[n]) {
                            queue.offer(n);
                            visited[n] = true;
                        }
                    }
                }

                count += 1;
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}