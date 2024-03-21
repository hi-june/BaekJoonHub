import java.util.*;

class Solution {
    private static class Food implements Comparable<Food> {
        public int scoville;
        
        public Food(int scoville) {
            this.scoville = scoville;
        }
        
        @Override
        public int compareTo(Food f) {
            if (this.scoville > f.scoville) {
                return 1;
            } else if (this.scoville == f.scoville) {
                return 0;
            } else {
                return -1;
            }
        }
    }
    
    public int solution(int[] scoville, int K) {
        PriorityQueue<Food> queue = new PriorityQueue<>();
        
        for (int s : scoville) {
            queue.offer(new Food(s));
        }
        
        int count = 0;
        
        // scoville의 최솟값이 K 이상인 경우
        if (queue.peek().scoville >= K) {
            return count;
        }
        
        while (queue.size() >= 2) {
            Food minFood = queue.poll();
            Food nextFood = queue.poll();
            
            int mixScoville = minFood.scoville + (nextFood.scoville * 2);
            queue.offer(new Food(mixScoville));
            count++;
            
            if (queue.peek().scoville >= K) {
                return count;
            }
        }
        
        return -1;
    }
}