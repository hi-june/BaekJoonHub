import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int F, S, G, U, D;
    static class Node {
        int floor;
        int depth;

        public Node(int floor, int depth) {
            this.floor = floor;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        // 첫째 줄에 F, S, G, U, D가 주어진다. (1 ≤ S, G ≤ F ≤ 1000000, 0 ≤ U, D ≤ 1000000)
        // 건물은 1층부터 시작하고, 가장 높은 층은 F층이다.

        int[] inputs = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        F = inputs[0];  // 전체 층 수
        S = inputs[1];  // 시작 층
        G = inputs[2];  // 도착 층
        U = inputs[3];  // 위로 U층
        D = inputs[4];  // 아래로 D층

        // S-> G 최단 거리, 없으면 "use the stairs" 출력
        boolean[] visited = new boolean[F + 1];
        int[] step = {U, D * -1};

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(S, 0));
        visited[S] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.floor == G) {
                bw.write(node.depth + "");

                bw.flush();

                br.close();
                bw.close();

                return;
            }

            for (int s : step) {
                int dFloor = node.floor + s;

                if (dFloor > F || dFloor <= 0) continue;
                if (visited[dFloor]) continue;

                queue.offer(new Node(dFloor, node.depth + 1));
                visited[dFloor] = true;
            }
        }

        bw.write("use the stairs");

        bw.flush();

        br.close();
        bw.close();
    }
}


