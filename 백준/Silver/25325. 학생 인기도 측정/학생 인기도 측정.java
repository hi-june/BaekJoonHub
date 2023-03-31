import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 학생 수
        int n = Integer.parseInt(br.readLine());

        // 학생 목록
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 학생 별 인기도 Map
        Map<String, Integer> students = new HashMap<>();
        for (int i = 0; i < n; i++) {
            students.put(st.nextToken(), 0);
        }

        // 학생 별로 인기도 조사
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                String student = st.nextToken();
                students.put(student, students.get(student) + 1);
            }
        }

        // key List를 value를 기준으로 정렬
        List<String> keyList = new ArrayList<>(students.keySet());

        keyList.sort((k1, k2) -> {
            if (students.get(k1) - students.get(k2) == 0)
                return k1.compareTo(k2);
            return students.get(k2) - students.get(k1);
        });

        // value 기준으로 정렬한대로 결과 출력
        keyList.forEach(k -> System.out.println(k + " " + students.get(k)));
    }
}