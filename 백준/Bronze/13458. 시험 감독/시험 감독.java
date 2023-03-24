import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());    // 시험장의 수
        int[] a = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray(); // 각 시험장에 있는 학생 수를 담은 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());   // 총 감독관이 감시 가능한 학생 수
        int c = Integer.parseInt(st.nextToken());   // 부 감독관이 감시 가능한 학생 수

        long total = 0; // int 자료형의 최대 범위는 약 21억이다.
        for (int i = 0; i < a.length; i++) {
            a[i] -= b;
            total += 1;

            if (a[i] > 0) {
                // 몫을 더하는 방식
                if (a[i] % c != 0) {
                    total += (a[i] / c) + 1;
                } else {
                    total += (a[i] / c);
                }
            }
        }

        bw.write(String.valueOf(total));
        bw.flush();
        bw.close();
    }
}