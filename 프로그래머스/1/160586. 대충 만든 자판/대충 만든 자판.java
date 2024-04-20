import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<String, Integer> alphabetMap = new HashMap<>();
        
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                String letter = key.substring(i, i + 1);
                
                if (alphabetMap.containsKey(letter)) {
                    if (i + 1 >= alphabetMap.get(letter)) {
                        continue;
                    }
                }
                
                alphabetMap.put(letter, i + 1);
            }
        }
        
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            
            int count = 0;
            for (int j = 0; j < target.length(); j++) {
                String key = target.substring(j, j + 1);
                
                if (!alphabetMap.containsKey(key)) {
                    answer[i] = -1;
                    break;
                }
                count += alphabetMap.get(key);
            }
            
            if (answer[i] != -1) {
                answer[i] = count;
            }
        }
        
        return answer;
    }
}