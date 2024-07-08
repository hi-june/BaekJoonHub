import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        if (k >= enemy.length) {
            return enemy.length;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < enemy.length; i++) {
            int e = enemy[i];
            
            if (pq.size() == k) {
                pq.offer(e);
                
                int p = pq.poll();
                
                if (p > n) return i;
                n -= p;
            } else {
                pq.offer(e);
            }
        }
        
        return enemy.length;
    }
}