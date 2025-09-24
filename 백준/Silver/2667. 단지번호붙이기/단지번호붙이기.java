import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] map;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static class Node {
        int col;
        int row;

        private Node(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        List<Integer> houseCount = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) continue;

                int count = 0;

                Queue<Node> queue = new LinkedList<>();
                queue.offer(new Node(i, j));
                map[i][j] = 0;
                count++;

                while (!queue.isEmpty()) {
                    Node node = queue.poll();

                    for (int[] d : directions) {
                        int dCol = node.col + d[0];
                        int dRow = node.row + d[1];

                        if (dCol >= N || dCol < 0 || dRow >= N || dRow < 0) continue;

                        if (map[dCol][dRow] != 0) {
                            queue.offer(new Node(dCol, dRow));
                            map[dCol][dRow] = 0;
                            count++;
                        }
                    }
                }

                if (count > 0) houseCount.add(count);
            }
        }

        Collections.sort(houseCount);
        bw.write(houseCount.size() + "\n");

        for (int c : houseCount) {
            bw.write(c + "\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}


