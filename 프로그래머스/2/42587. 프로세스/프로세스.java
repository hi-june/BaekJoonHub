import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int idx = 0; idx < priorities.length; idx++) {
            queue.offer(idx);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int idx = queue.poll();

            int priority = priorities[idx];
            long biggerCount = queue.stream()
                .filter(i -> priorities[i] > priority)
                .count();

            if (biggerCount > 0) {
                queue.offer(idx);
            } else {
                count += 1;
                if (idx == location) break;
            }
        }

        return count;
    }
}