import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean err = false;

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int flag = 1;

        for (int num : nums) {
            if (stack.isEmpty() || num != stack.peek()) {
                if (!stack.isEmpty() && num < stack.peek()) {
                    err = true;
                }
                while (flag <= num) {
                    stack.push(flag);
                    sb.append("+").append("\n");
                    flag += 1;
                }
            }
            stack.pop();
            sb.append("-").append("\n");
        }

        if (err) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}