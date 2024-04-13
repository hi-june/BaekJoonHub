import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        long S = Long.parseLong(inputs[1]);

        long[] nums = Arrays.stream(br.readLine().split(" "))
            .mapToLong(Long::parseLong)
            .toArray();

        if (Arrays.stream(nums).sum() == S) {
            bw.write(Integer.toString(nums.length));
            bw.flush();

            br.close();
            bw.close();
            return;
        }

        int start = 0;
        int end = nums.length - 1;

        int s = 0;
        int e = s;
        long total = nums[s];

        while (s < nums.length) {
            if (total >= S) {
                if (e - s < end - start) {
                    end = e;
                    start = s;
                }

                total = total - nums[s++];
            } else if (e < nums.length - 1) {
                total = total + nums[++e];
            } else {
                break;
            }
        }

        int answer = (end - start == nums.length - 1) ? 0 : end - start + 1;

        bw.write(Integer.toString(answer));
        bw.flush();

        br.close();
        bw.close();
    }
}