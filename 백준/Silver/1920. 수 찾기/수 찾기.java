import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] nArray = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int m = Integer.parseInt(br.readLine());
        int[] mArray = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 이진 탐색을 위한 정렬이 선행되어야 함
        Arrays.sort(nArray);

        for (int i = 0; i < m; i++) {
            if (Arrays.binarySearch(nArray, mArray[i]) < 0) {   // 없는 경우
                bw.write("0\n");
            } else {
                bw.write("1\n");
            }
        }

        bw.flush();
        bw.close();
    }
}