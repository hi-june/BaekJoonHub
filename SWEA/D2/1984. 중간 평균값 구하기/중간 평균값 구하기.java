import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            Arrays.sort(line);

            int total = 0;
            for (int j = 1; j < 9; j++) {
                total += line[j];
            }

            double avg = (double) total / 8;
            bw.write(String.format("#%d %d\n", i + 1, (int)Math.round(avg)));
        }

        bw.flush();

        br.close();
        bw.close();
    }
}