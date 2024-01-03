import java.util.*;

class Solution {
    public int solution(int n) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (i == n / i) {
                    list.add(i);
                } else {
                    list.add(i);
                    list.add(n / i);
                }
            }
        }
        
        return list.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }
}