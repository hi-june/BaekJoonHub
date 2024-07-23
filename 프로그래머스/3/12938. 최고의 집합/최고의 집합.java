import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};
        
        int[] answer = new int[n];
        for (int i = 0; i < answer.length; i++) {
            int t = s / n;
            
            answer[i] = t;
            s -= t;
            n--;
        }
        
        return answer;
    }
}