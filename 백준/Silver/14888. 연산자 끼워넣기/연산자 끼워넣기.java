import java.io.*;
import java.util.*;

public class Main {
    private static final String[] OPS = {"+", "-", "*", "/"};

    private static class Node {
        String val;
        int step;
        int[] history;

        private Node(String val, int step, int[] history) {
            this.val = val;
            this.step = step;
            this.history = history;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int[] opInfo = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        Set<Integer> result = new HashSet<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", 0, opInfo));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.step == N - 1) {
                result.add(getResult(nums, node.val));
                continue;
            }

            int[] history = node.history;
            for (int i = 0; i < history.length; i++) {
                if (history[i] == 0) continue;

                int[] newHistory = Arrays.copyOf(history, history.length);
                newHistory[i] -= 1;
                queue.offer(new Node(node.val + OPS[i], node.step + 1, newHistory));
            }
        }

        int max = Collections.max(result);
        int min = Collections.min(result);

        bw.write(max + "\n" + min);
        bw.flush();

        br.close();
        bw.close();
    }

    private static int getResult(int[] nums, String val) {
        int result = nums[0];

        for (int i = 0; i < val.length(); i++) {
            char ops = val.charAt(i);

            switch (ops) {
                case '+': {
                    result += nums[i + 1];
                    break;
                }
                case '-': {
                    result -= nums[i + 1];
                    break;
                }
                case '*': {
                    result *= nums[i + 1];
                    break;
                }
                case '/': {
                    result /= nums[i + 1];
                    break;
                }
            }
        }

        return result;
    }
}