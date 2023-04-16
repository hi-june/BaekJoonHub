import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // initialize mace
        int[][] mace = new int[n][m];

        for (int i = 0; i < n; i++) {
            mace[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        // move: 상, 하, 좌, 우
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        // bfs
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));    // graph의 인덱스 때문에 (1,1)을 (0,0)으로 취급

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.getX();
            int y = node.getY();

            for (int i = 0; i < 4; i++) {   // 상, 하, 좌, 우 각각 한 번씩 움직여보기
                int movedX = x + dx[i];
                int movedY = y + dy[i];

                // 미로를 벗어나는 경우면 제외
                if (movedX >= n || movedX < 0 || movedY >= m || movedY < 0 || mace[movedX][movedY] == 0) continue;

                if (mace[movedX][movedY] == 1) {
                    mace[movedX][movedY] = mace[x][y] + 1;  // 이동하면서 미로에 이동 거리 세기기
                    queue.offer(new Node(movedX, movedY));
                }
            }
        }

        System.out.println(mace[n-1][m-1]);
    }
}