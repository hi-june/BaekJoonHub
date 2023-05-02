import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 좌표의 갯수
        int n = Integer.parseInt(br.readLine());

        // original array
        int[] point = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // copy of original array
        int[] pointCopy = Arrays.copyOf(point, point.length);
        Arrays.sort(pointCopy); // 정렬

        // raking Map
        Map<Integer, Integer> rakingMap = new HashMap<>();
        int rank = 0;

        for (int i = 0; i < pointCopy.length; i++) {
            if (!rakingMap.containsKey(pointCopy[i])) {
                rakingMap.put(pointCopy[i], rank);
                rank += 1;
            }
        }

        // 해당 point의 인덱스 = 자신보다 작은 좌표의 갯수
        for (int p : point) {
            sb.append(rakingMap.get(p)).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}