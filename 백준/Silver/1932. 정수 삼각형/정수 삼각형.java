import java.util.*;
import java.util.stream.*;
import java.io.*;

class Main {
    static int[][] triangle;
    static int[][] memoization;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        triangle = new int[n][];
        memoization = new int[n][];

        for (int i = 0; i < n; i++) {
            triangle[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            memoization[i] = new int[triangle[i].length];
            Arrays.fill(memoization[i], -1);    // memoization을 -1로 초기화
        }

        // 맨 마지막 줄 복사
        memoization[n - 1] = Arrays.copyOf(triangle[n - 1], n);

        System.out.println(find(0, 0));
    }

    /**
     * 맨 밑 줄부터 역으로 올라가면서 최대 누적합을 계산
     * @param depth
     * @param idx
     * @return
     */
    static int find(int depth, int idx) {
        if (depth == n - 1) {
            return memoization[depth][idx];
        }

        if (memoization[depth][idx] == -1) {    // 첫 방문
            memoization[depth][idx] = triangle[depth][idx] + Math.max(find(depth + 1, idx), find(depth + 1, idx + 1));
        }

        return memoization[depth][idx];
    }
}