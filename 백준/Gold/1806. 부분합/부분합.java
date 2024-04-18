import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int S = Integer.parseInt(inputs[1]);

        inputs = br.readLine().split(" ");
        int[] nums = Arrays.stream(inputs)
            .mapToInt(Integer::parseInt)
            .toArray();

        int start = 0;
        int end = N - 1;

        int s = 0;
        int e = s;

        int total = Arrays.stream(nums).sum();
        if (total == S) {
            bw.write(Integer.toString(N));
            bw.flush();

            bw.close();
            br.close();
            return;
        }

        int sum = nums[s];
        while (s <= e) {
            if (sum >= S) {
                if (e - s < end - start) {
                    start = s;
                    end = e;
                }

                sum -= nums[s];
                s++;
            } else if (e < N - 1) {
                e++;
                sum += nums[e];
            } else {
                break;
            }
        }

        int answer = (end - start + 1 == N) ? 0 : end - start + 1;
        bw.write(Integer.toString(answer));

        br.close();
        bw.close();
    }
}