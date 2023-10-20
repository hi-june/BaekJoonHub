import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answers = new int[photo.length];
        
        Map<String, Integer> scores = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            scores.put(name[i], yearning[i]);
        }
        
        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            
            for (String p : photo[i]) {
                score += scores.getOrDefault(p, 0);
            }
            
            answers[i] = score;
        }
        
        return answers;
    }
}