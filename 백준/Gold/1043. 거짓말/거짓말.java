import java.io.*;
import java.util.*;

public class Main {
    private static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] inputs = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int N = inputs[0];  // 사람의 수
        int M = inputs[1];  // 파티의 수

        map = new int[N + 1];
        for (int i = 1; i < map.length; i++) {
            map[i] = i;
        }

        // 이야기의 진실을 아는 사람의 수와 번호
        inputs = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        boolean avail = true;
        int trueNode = -1;
        if (inputs.length > 1) {
            avail = false;

            trueNode = inputs[1];

            for (int i = 2; i < inputs.length; i++) {
                merge(trueNode, inputs[i]);
            }
        }

        // 파티 정보 초기화
        int[][] partyInfos = new int[M][];
        for (int i = 0; i < M; i++) {
            inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            partyInfos[i] = inputs;

            int firstNode = inputs[1];
            for (int j = 2; j < inputs.length; j++) {
                merge(firstNode, inputs[j]);
            }
        }

        // map 초기화
        for (int i = 1; i < map.length; i++) {
            findRoot(i);
        }

        // 갯수 세기
        if (avail) {
            bw.write(Integer.toString(M));
            bw.flush();
            bw.close();
            br.close();

            return;
        }

        int count = 0;
        for (int[] partyInfo : partyInfos) {
            if (lieAvail(partyInfo, trueNode)) {
                count++;
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void merge(int node1, int node2) {
        int root1 = findRoot(node1);
        int root2 = findRoot(node2);

        if (root1 < root2) {
            map[root2] = root1;
        } else if (root1 > root2) {
            map[root1] = root2;
        }
    }

    private static int findRoot(int node) {
        if (map[node] != node) {
            map[node] = findRoot(map[node]);
        }

        return map[node];
    }

    private static boolean lieAvail(int[] partyInfo, int trueNode) {
        int trueRoot = map[trueNode];

        for (int i = 1; i < partyInfo.length; i++) {
            int node = partyInfo[i];

            if (trueRoot == map[node]) {
                return false;
            }
        }

        return true;
    }
}