import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            
            if (answer == student1[i % student1.length]) {
                count1 += 1;
            }
            if (answer == student2[i % student2.length]) {
                count2 += 1;
            }
            if (answer == student3[i % student3.length]) {
                count3 += 1;
            }
        }
        
        Map<Integer, Integer> scores = new HashMap<>();
        scores.put(1, count1);
        scores.put(2, count2);
        scores.put(3, count3);
        
        int[] counts = new int[3];
        counts[0] = count1;
        counts[1] = count2;
        counts[2] = count3;
        
        Arrays.sort(counts);
        int maxCount = counts[2];
        
        List<Integer> answer = new ArrayList<>();
        for (int key : scores.keySet()) {
            if (scores.get(key) == maxCount) {
                answer.add(key);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}