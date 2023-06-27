import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    static String[][] cookie;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        cookie = new String[N][];
        for (int i = 0; i < N; i++) {
            cookie[i] = br.readLine().split("");
        }

        int x = -1; // 행
        int y = -1; // 열

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isHeart(i, j)) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        List<Integer> answer = new ArrayList<>();

        // 왼팔
        int leftLen = 0;
        for (int i = y - 1; i >= 0; i--) {
            if (!cookie[x][i].equals("*")) {
                break;
            }
            leftLen += 1;
        }
        answer.add(leftLen);

        // 오른팔
        int rightLen = 0;
        for (int i = y + 1; i < N; i++) {
            if (!cookie[x][i].equals("*")) {
                break;
            }
            rightLen += 1;
        }
        answer.add(rightLen);

        // 몸통
        int bodyLen = 0;
        for (int i = x + 1; i < N; i++) {
            if (!cookie[i][y].equals("*")) {
                break;
            }
            bodyLen += 1;
        }
        answer.add(bodyLen);

        // 몸통 끝 좌표
        int bodyEndX = x + bodyLen;
        int bodyEndY = y;

        // 왼쪽 다리
        int leftLegLen = 0;
        for (int i = bodyEndX + 1; i < N; i++) {
            if (!cookie[i][bodyEndY - 1].equals("*")) {
                break;
            }
            leftLegLen += 1;
        }
        answer.add(leftLegLen);

        // 오른쪽 다리
        int rightLegLen = 0;
        for (int i = bodyEndX + 1; i < N; i++) {
            if (!cookie[i][bodyEndY + 1].equals("*")) {
                break;
            }
            rightLegLen += 1;
        }
        answer.add(rightLegLen);

        // 출력
        bw.write((x + 1) + " " + (y + 1) + "\n");
        bw.write(answer.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "))
        );

        bw.flush();
        bw.close();

        br.close();
    }

    public static boolean isHeart(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];

            if (mx < 0 || mx >= N || my < 0 || my >= N) {
                return false;
            }

            if (!cookie[mx][my].equals("*")) {
                return false;
            }
        }

        return true;
    }
}