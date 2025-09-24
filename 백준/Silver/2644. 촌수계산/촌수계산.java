import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inputs = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int t1 = inputs[0];
        int t2 = inputs[1];

        int E = Integer.parseInt(br.readLine());
        for (int i = 0; i < E; i++) {
            inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            int f = inputs[0];
            int t = inputs[1];

            graph.get(f).add(t);
            graph.get(t).add(f);
        }

        // t1 -> t2
        int[] dists = new int[N + 1];
        Arrays.fill(dists, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(t1);
        dists[t1] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == t2) break;

            for (int adj : graph.get(node)) {
                if (dists[adj] == -1) {
                    queue.offer(adj);
                    dists[adj] = dists[node] + 1;
                }
            }
        }

        bw.write(dists[t2] + "");
        bw.flush();

        br.close();
        bw.close();
    }
}


