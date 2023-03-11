import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 최대공약수: 약수들끼리 겹치는 수
        // 최소공배수: 두 수의 곱 / 최대공약수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        
        int x = Integer.parseInt(st.nextToken().toString());
        int y = Integer.parseInt(st.nextToken().toString());

        int max = 1;    // 최대공약수
        for (int i = 1; i <= x && i <= y; i++) {
            if (x % i == 0 && y % i == 0) {
                if (i > max) max = i;
            }
        }
        
        int min = (x * y) / max;    // 최소 공배수
        bw.write(max + "\n" + min);

        bw.flush();
        bw.close();
    }
}