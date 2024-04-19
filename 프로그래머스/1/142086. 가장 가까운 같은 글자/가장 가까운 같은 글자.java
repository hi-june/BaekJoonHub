import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        int[] answer = new int[s.length()];
        
        for (int idx = 0; idx < s.length(); idx++) {
            String letter = s.substring(idx, idx + 1);
            
            if (!map.containsKey(letter)) {
                answer[idx] = -1;
            } else {
                int letterIdx = map.get(letter);
                answer[idx] = idx - letterIdx;
            }
            
            map.put(letter, idx);
        }
        
        return answer;
    }
}