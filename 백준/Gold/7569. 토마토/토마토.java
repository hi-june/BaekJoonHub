import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x;
        int y;
        int z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int getX() { return x; }

        public int getY() { return y; }

        public int getZ() { return z; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());   // x
        int n = Integer.parseInt(st.nextToken());   // y
        int k = Integer.parseInt(st.nextToken());   // z

        Queue<Node> ripenTomato = new LinkedList<>();   // 익은 토마토
        int unRipenTomato = 0;  // 안 익은 토마토
        int day = 0;    // 소요 날짜

        // initialize box
        int[][][] box = new int[k][n][m];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < m; l++) {
                    box[i][j][l] = Integer.parseInt(st.nextToken());
                    
                    if (box[i][j][l] == 0) unRipenTomato += 1;  // 안 익은 토마토
                    else if (box[i][j][l] == 1) {
                        ripenTomato.offer(new Node(l, j, i));   // 익은 토마토
                    }
                }
            }
        }

        // 이동: 상, 하, 좌, 우, 전, 후
        int[] dx = {0, 0, -1, 1, 0, 0};
        int[] dy = {0, 0, 0, 0, 1, -1};
        int[] dz = {1, -1, 0, 0, 0, 0};

        // bfs(인접 토마토 익히기)
        while (unRipenTomato > 0 && !ripenTomato.isEmpty()) {
            int todayRipenTomato = ripenTomato.size();  // '오늘' 익어있는 토마토

            for (int i = 0; i < todayRipenTomato; i++) {
                Node node = ripenTomato.poll();

                int x = node.getX();
                int y = node.getY();
                int z = node.getZ();

                // 6방향으로 토마토 익히기
                for (int j = 0; j < 6; j++) {
                    int movedX = x + dx[j];
                    int movedY = y + dy[j];
                    int movedZ = z + dz[j];

                    // 범위를 벗어나거나 안 익은 토마토가 아닌 경우는 제외
                    if (movedX < 0 || movedX >= m || movedY < 0 || movedY >= n || movedZ < 0 || movedZ >= k || box[movedZ][movedY][movedX] != 0) continue;

                    unRipenTomato -= 1; // 안 익은 토마토 개수 줄이기
                    box[movedZ][movedY][movedX] = 1;    // 토마토 익히기
                    ripenTomato.offer(new Node(movedX, movedY, movedZ));
                }
            }

            day += 1;
        }

        if (unRipenTomato == 0) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }
}