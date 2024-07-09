import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long count = 0;
        Map<Double, Integer> map = new HashMap<>();
        
        Arrays.sort(weights);
        for (int w : weights) {
            double w1 = (double) w;
            double w2 = (double) w * 2 / 3;
            double w3 = (double) w * 2 / 4;
            double w4 = (double) w * 3 / 4;
            
            if (map.containsKey(w1)) count += map.get(w1);
            if (map.containsKey(w2)) count += map.get(w2);
            if (map.containsKey(w3)) count += map.get(w3);
            if (map.containsKey(w4)) count += map.get(w4);
            
            map.put(w1, map.getOrDefault(w1, 0) + 1);
        }
        
        return count;
    }
}