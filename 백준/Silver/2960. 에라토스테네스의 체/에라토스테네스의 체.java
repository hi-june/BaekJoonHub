import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] nums = IntStream.range(0, n + 1).toArray();   // 인덱스와 숫자가 똑같도록 만들기 위해 0부터 배열 초기화

        int count = 0;
        for (int i = 2; i < nums.length; i++) {
            for (int j = i; j < nums.length; j += i) {  // 배수 세기 == 그 숫자만큼 더하면서 건너뛰기
                if (nums[j] == 0) continue; // 이미 지워진 경우는 pass

                count += 1;
                if (count == k) {
                    bw.write(String.valueOf(nums[j]));
                    bw.flush();
                    bw.close();
                    return;
                }
                nums[j] = 0;
            }
        }
    }
}