import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int countHanNum = 0;
        for (int i = 1; i <= n; i++) {
            if (isHanNum(i)) countHanNum += 1;
        }

        System.out.println(countHanNum);
    }

    public static boolean isHanNum(int n) {
        // 1자리부터 2자리까지는 n에 값에 관계없이 각 자리수가 등차수열을 이룸
        if (n >= 1 && n <= 99) {
            return true;
        }

        // 문자의 각 자리 숫자로 이루어진 정수형 배열 선언
        int[] digit = Arrays.stream(String.valueOf(n).split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 차이가 같은지 비교
        int diff = digit[0] - digit[1];
        for (int i = 1; i < digit.length - 1; i++) {
            if (digit[i] - digit[i+1] != diff) {
                return false;
            }
        }

        return true;
    }
}