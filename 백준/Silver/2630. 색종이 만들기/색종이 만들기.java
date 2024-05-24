import java.io.*;
import java.util.*;

public class Main {
    private static int blueCount = 0;
    private static int whiteCount = 0;
    private static int[][] img;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        img = new int[N][N];

        for (int i = 0; i < N; i++) {
            img[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        cut(0, 0, N);
        bw.write(String.format("%d\n%d", whiteCount, blueCount));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void cut(int col, int row, int size) {
        if (isPossible(col, row, size)) {
            switch (img[col][row]) {
                case 1: {
                    blueCount++;
                    return;
                }
                case 0: {
                    whiteCount++;
                    return;
                }
            }
        }

        int halfSize = size / 2;
        cut(col, row, halfSize);
        cut(col, row + halfSize, halfSize);
        cut(col + halfSize, row, halfSize);
        cut(col + halfSize, row + halfSize, halfSize);
    }

    private static boolean isPossible(int col, int row, int size) {
        int val = img[col][row];

        for (int i = col; i < col + size; i++) {
            for (int j = row; j < row + size; j++) {
                if (val != img[i][j]) return false;
            }
        }

        return true;
    }
}