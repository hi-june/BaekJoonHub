import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static int[][] img;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        img = new int[N][N];

        for (int i = 0; i < N; i++) {
            img[i] = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        QuadTree(0, 0, N);
        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void QuadTree(int col, int row, int size) {
        if (isPossible(col, row, size)) {
            sb.append(img[col][row]);
            return;
        }

        sb.append("(");

        int newSize = size / 2;
        QuadTree(col, row, newSize);
        QuadTree(col, row + newSize, newSize);
        QuadTree(col + newSize, row, newSize);
        QuadTree(col + newSize, row + newSize, newSize);

        sb.append(")");
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