import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer input = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(input.nextToken());
        int n = Integer.parseInt(input.nextToken());

        int[] nums = IntStream.range(0, n + 1).toArray();
        nums[1] = 0;    // 1은 소수에서 제외!

        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            if (nums[i] == 0) continue;
            for (int j = i * i; j < nums.length; j += i) {
                nums[j] = 0;
            }
        }

        for (int i = m; i <= n; i++) {
            if (nums[i] != 0) bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }
}