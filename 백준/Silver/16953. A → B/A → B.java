import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        long result;
        long step;

        private Node(long result, long step) {
            this.result = result;
            this.step = step;
        }
    }

    public static void main(String[] args) throws IOException {
        // Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]); // start
        long B = Long.parseLong(input[1]); // target

        long min = -1;

        // 2를 곱하거나 1을 수의 가장 오른쪽에 추가한다.
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(A, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.result == B) {
                min = node.step + 1;
                break;
            }

            if (node.result > B) continue;

            queue.offer(new Node(node.result * 2, node.step + 1));
            queue.offer(new Node((node.result * 10) + 1, node.step + 1));
        }

        bw.write(Long.toString(min));
        bw.flush();

        br.close();
        bw.close();
    }
}