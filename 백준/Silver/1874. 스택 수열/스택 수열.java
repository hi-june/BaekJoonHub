import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean err = false;

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int temp = 1;
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            for( ; temp <= num ; temp++) {
                stack.push(temp);
                sb.append("+").append("\n");
            }

            if(stack.peek()==num) {
                stack.pop();
                sb.append("-").append("\n");
            }else {
                err = true;
            }
        }

        if(err)
            System.out.println("NO");
        else
            System.out.println(sb);
    }
}