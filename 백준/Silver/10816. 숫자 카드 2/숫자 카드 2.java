import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Integer> card = new HashMap<>();   // key: 카드 숫자, value: 각 숫자의 갯수

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(st.nextToken());
            card.put(key, card.getOrDefault(key, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int key = Integer.parseInt(st.nextToken());
            bw.write(card.getOrDefault(key, 0) + " ");
        }
        bw.flush();
        bw.close();
    }
}