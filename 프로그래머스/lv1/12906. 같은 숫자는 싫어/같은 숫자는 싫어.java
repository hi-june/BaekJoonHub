import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> answerList = new ArrayList<>();
        
        for (int n : arr) {
            if (answerList.isEmpty() || answerList.get(answerList.size() - 1) != n) {
                answerList.add(n);
            }
        }
        
        return answerList.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}