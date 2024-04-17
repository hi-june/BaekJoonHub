import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        List<Integer> scores = Arrays.stream(score)
            .boxed()
            .sorted((i1, i2) -> i2 - i1)
            .collect(Collectors.toList());
        
        int boxCount = score.length / m;
        int idx = m - 1;
        int total = 0;
        
        for (int i = 0; i < boxCount; i++) {
            int min = scores.get(idx);
            total += min * m;
            
            idx += m;
        }
        
        return total;
    }
}