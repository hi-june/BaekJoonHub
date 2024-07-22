import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        // [8, 8, 8, 6, 2]
        PriorityQueue<Integer> sortedWorks = new PriorityQueue<>(Comparator.reverseOrder());
        for (int w : works) {
            sortedWorks.offer(w);
        }
        
        while (n > 0) {
            int w = sortedWorks.poll();
            
            if (w == 0) return 0;
            
            w--;
            sortedWorks.offer(w);
            n--;
        }
        
        long answer = 0;
        while (!sortedWorks.isEmpty()) {
            answer += (long)Math.pow(sortedWorks.poll(), 2);
        }
        
        return answer;
    }
}