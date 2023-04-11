import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());    // 책의 개수
        int m = Integer.parseInt(st.nextToken());    // 한 번에 들 수 있는 책의 개수

        List<Integer> leftSide = new ArrayList<>();
        List<Integer> rightSide = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int bookPoint = Integer.parseInt(st.nextToken());

            if (bookPoint < 0) {
                leftSide.add(bookPoint * (-1));
            } else {
                rightSide.add(bookPoint);
            }
        }

        rightSide.sort((i1, i2) -> i2 - i1);    // 내림차순 정렬
        leftSide.sort((i1, i2) -> i2 - i1);    // 내림차순 정렬

        int steps = 0;

        for (int i = 0; i < rightSide.size(); i+=m) {
            steps += rightSide.get(i) * 2;
        }
        for (int i = 0; i < leftSide.size(); i+=m) {
            steps += leftSide.get(i) * 2;
        }

        if (rightSide.size() == 0 || (leftSide.size() != 0 && rightSide.get(0) < leftSide.get(0))) {
            steps -= leftSide.get(0);
        } else if (leftSide.size() == 0 || (rightSide.size() != 0 && rightSide.get(0) > leftSide.get(0))) {
            steps -= rightSide.get(0);
        }

        System.out.println(steps);
    }
}