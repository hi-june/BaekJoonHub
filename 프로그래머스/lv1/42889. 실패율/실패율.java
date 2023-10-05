import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> ranking = new HashMap<>();
        
        for (int i = 1; i <= N; i++) {
            int finalI = i;
            
            long n = Arrays.stream(stages)
                .filter(s -> s == finalI)
                .count();
            long m = Arrays.stream(stages)
                .filter(s -> s >= finalI)
                .count();
            
            double rank = (m == 0) ? 0 : (double)n / m;
            ranking.put(i, rank);
        }
        
        return ranking.keySet().stream()
                .sorted((k1, k2) -> {
                    if (ranking.get(k2).compareTo(ranking.get(k1)) == 0) {
                        return k1.compareTo(k2);
                    }
                    return ranking.get(k2).compareTo(ranking.get(k1));
                })
                .mapToInt(Integer::intValue)
                .toArray();
    }
}