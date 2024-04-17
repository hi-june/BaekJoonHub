import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        Arrays.sort(nums);

        int start = 0;
        int end = nums.length - 1;
        int s = 0;
        int e = nums.length - 1;

        int min = Integer.MAX_VALUE;

        while (s < e) {
            int value = nums[s] + nums[e];

            if (Math.abs(value) < min) {
                min = Math.abs(value);

                start = s;
                end = e;
            }

            if (value < 0) {
                s++;
            } else if (value > 0){
                e--;
            } else {
                break;
            }
        }

        bw.write(String.format("%d %d", nums[start], nums[end]));
        bw.flush();

        br.close();
        bw.close();
    }
}