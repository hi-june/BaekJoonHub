import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> ranking = new PriorityQueue<>();
        
        for (int i = 0; i < score.length; i++) {            
            if (ranking.size() < k) {
                ranking.offer(score[i]);
            } else {
                ranking.offer(score[i]);
                ranking.poll();
            }
            
            answer[i] = ranking.peek();
        }
        
        return answer;
    }
}