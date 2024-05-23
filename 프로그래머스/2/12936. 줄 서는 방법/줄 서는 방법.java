import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int idx = 0;
        int[] answer = new int[n];
        
        long facto = 1;
        List<Integer> people = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            facto *= i;
            people.add(i);
        }
        
        k--;
        while (n > 0) {
            facto = facto / n;
            
            int targetIdx = (int) (k / facto);
            answer[idx++] = people.get(targetIdx);
            people.remove(targetIdx);
            
            k = k % facto;
            n--;
        }
        
        return answer;
    }
}