import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> brackets = Arrays.asList("(", ")", "[", "]");

        while (true) {
            String input = br.readLine();

            if (input.equals(".")) break;   // EOF trigger (End Of File)

            // 각 문장을 리스트로 변환
            List<String> sentence = Arrays.stream(input.split("")).collect(Collectors.toList());

            // 괄호를 넣어줄 stack 선언
            Deque<String> stack = new ArrayDeque<>();

            for (String s : sentence) {
                // 괄호가 아닌 문자는 skip
                if (!brackets.contains(s)) {
                    continue;
                }

                if (stack.isEmpty() || !isPair(stack.peek(),s)) {
                    stack.push(s);  // stack이 비어있거나 짝이 안 맞는 경우 push
                } else {
                    stack.pop();    // 짝이 맞으면 pop
                }
            }

            if (stack.isEmpty()) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }

        bw.flush();
        bw.close();
    }

    public static boolean isPair(String s1, String s2) {
        if (s1.equals("(")) {
            return s2.equals(")");
        }
        if (s1.equals("[")) {
            return s2.equals("]");
        }
        return false;
    }
}