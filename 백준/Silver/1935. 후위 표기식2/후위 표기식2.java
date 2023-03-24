import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] ss = br.readLine().split("");
        List<String> operator = Arrays.asList("+", "-", "*", "/");

        // 각 변수에 맞는 숫자 변환
        for (int i = 0; i < n; i++) {
            String num = br.readLine();
            for (int j = 0; j < ss.length; j++) {
                if (ss[j].equals(Character.toString('A' + i))) {
                    ss[j] = num;
                }
            }
        }

        // stack을 사용한 후위 연산 수행
        Deque<String> stack = new ArrayDeque<>();
        for (String s : ss) {
            if (operator.contains(s)) {
                double y = Double.parseDouble(stack.pop());
                double x = Double.parseDouble(stack.pop());

                if (s.equals("+")) {
                    stack.push(String.format("%.2f", x + y));
                } else if (s.equals("-")) {
                    stack.push(String.format("%.2f", x - y));
                } else if (s.equals("*")) {
                    stack.push(String.format("%.2f", x * y));
                } else {
                    stack.push(String.format("%.2f", x / y));
                }
            } else {
                stack.push(s);
            }
        }

        bw.write(stack.pop());
        bw.flush();
        bw.close();
    }
}