import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());   // 가로 길이 == 열
        int m = Integer.parseInt(st.nextToken());   // 세로 길이 == 행
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("*");
        }
        
        String line = sb.toString();
        for (int i = 0; i < m; i++) {
            bw.write(line + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}