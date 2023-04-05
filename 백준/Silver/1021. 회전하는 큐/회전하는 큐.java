import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 큐의 크기
        int m = Integer.parseInt(st.nextToken());   // 뽑아내는 수의 크기

        // 뽑아내야하는 수를 담은 배열
        int[] targetArray = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 원형 큐 초기화
        LinkedList<Integer> circularQueue = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            circularQueue.add(i);
        }

        int leftCount = 0;
        int rightCount = 0;

        // 제거 대상을 하나씩 제거
        for (int target : targetArray) {
            int idx = circularQueue.indexOf(target);

            if (idx <= circularQueue.size() / 2) {   // 좌측 이동
                while (circularQueue.indexOf(target) != 0) {
                    int tmp = circularQueue.removeFirst();
                    circularQueue.addLast(tmp);
                    leftCount += 1;
                }
            } else {    // 우측 이동
                while (circularQueue.indexOf(target) != 0) {
                    int tmp = circularQueue.removeLast();
                    circularQueue.addFirst(tmp);
                    rightCount += 1;
                }
            }

            circularQueue.removeFirst();    // 큐 이동이 끝난 후 맨 앞에 온 target을 제거
        }

        System.out.println(leftCount + rightCount);
    }
}