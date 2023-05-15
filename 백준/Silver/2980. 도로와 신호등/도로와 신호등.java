import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N: 신호등의 개수, L: 도로의 길이
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        // D: 신호등 위치, R: 빨간색 지속 시간, G: 초록색 지속 시간
        int[][] info = new int[N][];
        for (int i = 0; i < N; i++) {
            info[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int spentTime = 0;  // 현재까지 소요된 시간
        int currentPoint = 0;   // 현재 위치

        for (int i = 0; i < N; i++) {
            spentTime += info[i][0] - currentPoint;    // 신호등 위치까지 이동(to next)
            currentPoint = info[i][0];  // 현재 위치 갱신

            int redDuration = info[i][1];
            int greenDuration = info[i][2];
            int totalDuration = redDuration + greenDuration;
            int remain = spentTime % totalDuration;

            if (redDuration > remain) {
                spentTime += redDuration - remain;
            }
        }

        spentTime += L - currentPoint;

        System.out.println(spentTime);
    }
}